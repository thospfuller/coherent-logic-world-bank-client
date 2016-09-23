package com.coherentlogic.wb.client.webstart.application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.coherentlogic.coherent.data.adapter.application.GroovyEngine;
import com.coherentlogic.coherent.data.adapter.application.ObjectStringifier;
import com.coherentlogic.coherent.data.model.core.exceptions.InvalidURIException;
import com.coherentlogic.wb.client.core.builders.QueryBuilder;
import com.coherentlogic.wb.client.core.factories.QueryBuilderFactory;
import com.coherentlogic.wb.client.db.integration.dao.AdminRegionDAO;
import com.coherentlogic.wb.client.db.integration.dao.CatalogSourceDAO;
import com.coherentlogic.wb.client.db.integration.dao.CatalogSourcesDAO;
import com.coherentlogic.wb.client.db.integration.dao.CountriesDAO;
import com.coherentlogic.wb.client.db.integration.dao.CountryDAO;
import com.coherentlogic.wb.client.db.integration.dao.DataPointCountryDAO;
import com.coherentlogic.wb.client.db.integration.dao.DataPointDAO;
import com.coherentlogic.wb.client.db.integration.dao.DataPointIndicatorDAO;
import com.coherentlogic.wb.client.db.integration.dao.DataPointsDAO;
import com.coherentlogic.wb.client.db.integration.dao.IncomeLevelDAO;
import com.coherentlogic.wb.client.db.integration.dao.IncomeLevelsDAO;
import com.coherentlogic.wb.client.db.integration.dao.IndicatorDAO;
import com.coherentlogic.wb.client.db.integration.dao.IndicatorSourceDAO;
import com.coherentlogic.wb.client.db.integration.dao.IndicatorTopicDAO;
import com.coherentlogic.wb.client.db.integration.dao.IndicatorTopicsDAO;
import com.coherentlogic.wb.client.db.integration.dao.IndicatorsDAO;
import com.coherentlogic.wb.client.db.integration.dao.LendingTypeDAO;
import com.coherentlogic.wb.client.db.integration.dao.MessageDAO;
import com.coherentlogic.wb.client.db.integration.dao.RegionDAO;
import com.coherentlogic.wb.client.db.integration.dao.SourceDAO;
import com.coherentlogic.wb.client.db.integration.dao.TopicDAO;
import com.coherentlogic.wb.client.db.integration.dao.TopicsDAO;
import com.jamonapi.MonKey;
import com.jamonapi.MonKeyImp;
import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;

/**
 * The front-end for the World Bank Client that allows users to directly work
 * with the {@link com.coherentlogic.wb.client.core.builders.QueryBuilder}. 
 *
 * @author <a href="support@coherentlogic.com">Support</a>
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages="com.coherentlogic.wb.client")
public class WBClientGUI extends JFrame implements CommandLineRunner {

    private static final long serialVersionUID = 1L;

    private static final Logger log = LoggerFactory.getLogger(WBClientGUI.class);

    private URI uri = null;

    private static final String
        COUNTRIES = "Countries",
        CATALOG_SOURCES = "CatalogSources",
        INVALID_REQUEST = "InvalidRequest",
        INCOME_LEVELS = "IncomeLevels",
        INDICATORS = "Indicators",
        DATA_POINTS = "DataPoints";

    private static final String
        COUNTRIES_QUERY_BUILDER_FACTORY = "countriesQueryBuilderFactory",
        CATALOG_SOURCES_QUERY_BUILDER_FACTORY = "catalogSourcesQueryBuilderFactory",
        INVALID_REQUEST_QUERY_BUILDER_FACTORY =
            "invalidRequestQueryBuilderFactory",
        INCOME_LEVELS_QUERY_BUILDER_FACTORY = "incomeLevelsQueryBuilderFactory",
        INDICATORS_QUERY_BUILDER_FACTORY =
            "indicatorsQueryBuilderFactory",
        DATA_POINTS_QUERY_BUILDER_FACTORY =
            "dataPointsQueryBuilderFactory";

    private static final Map<String, String> beanIdMap = new HashMap<String, String> ();

    static {
        beanIdMap.put(COUNTRIES, COUNTRIES_QUERY_BUILDER_FACTORY);
        beanIdMap.put(CATALOG_SOURCES, CATALOG_SOURCES_QUERY_BUILDER_FACTORY);
        beanIdMap.put(INVALID_REQUEST, INVALID_REQUEST_QUERY_BUILDER_FACTORY);
        beanIdMap.put(INCOME_LEVELS, INCOME_LEVELS_QUERY_BUILDER_FACTORY);
        beanIdMap.put(INDICATORS, INDICATORS_QUERY_BUILDER_FACTORY);
        beanIdMap.put(DATA_POINTS, DATA_POINTS_QUERY_BUILDER_FACTORY);
    }

    private static final String
        QUERY_BUILDER = "queryBuilder",
        LOG = "log";

    private final JTextArea outputTextArea = new JTextArea();

    private final JButton runScriptButton = new JButton("Run script");

    private final ButtonGroup requestMenuItemsGroup = new ButtonGroup();

    private final Map<ButtonModel, JRadioButtonMenuItem> radioButtonMap =
        new HashMap<ButtonModel, JRadioButtonMenuItem> ();

    private GroovyEngine groovyEngine;

    private Map<String, QueryBuilderFactory> queryBuilderFactoryMap;

    private Map<String, String> exampleMap;

    @Autowired
    private ApplicationContext applicationContext;

    private final ObjectStringifier objectStringifier =
        new ObjectStringifier ();

    private final MonKey monKey = new MonKeyImp(
        "Call World Bank web services and return an instance of a domain class.",
        TimeUnit.MILLISECONDS.toString());

    /**
     * @see #initialize()
     */
    void initializeMenu (JTextArea inputTextArea) {

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnRequest = new JMenu("Examples");
        menuBar.add(mnRequest);

        JRadioButtonMenuItem countries = new JRadioButtonMenuItem(COUNTRIES);
        mnRequest.add(countries);

        countries.addActionListener(new MenuItemSelectedActionListener (exampleMap, inputTextArea));

        JRadioButtonMenuItem catalogSources = new JRadioButtonMenuItem(CATALOG_SOURCES);
        mnRequest.add(catalogSources);

        catalogSources.addActionListener(new MenuItemSelectedActionListener (exampleMap, inputTextArea));

        JRadioButtonMenuItem invalidRequest =new JRadioButtonMenuItem(INVALID_REQUEST);
        invalidRequest.setSelected(true);
        mnRequest.add(invalidRequest);

        invalidRequest.addActionListener(new MenuItemSelectedActionListener (exampleMap, inputTextArea));

        JRadioButtonMenuItem incomeLevels = new JRadioButtonMenuItem(INCOME_LEVELS);
        mnRequest.add(incomeLevels);

        incomeLevels.addActionListener(new MenuItemSelectedActionListener (exampleMap, inputTextArea));

        JRadioButtonMenuItem indicators = new JRadioButtonMenuItem(INDICATORS);
        mnRequest.add(indicators);

        indicators.addActionListener(new MenuItemSelectedActionListener (exampleMap, inputTextArea));

        JRadioButtonMenuItem dataPoints = new JRadioButtonMenuItem(DATA_POINTS);
        mnRequest.add(dataPoints);

        dataPoints.addActionListener(new MenuItemSelectedActionListener (exampleMap, inputTextArea));

        requestMenuItemsGroup.add(countries);
        requestMenuItemsGroup.add(catalogSources);
        requestMenuItemsGroup.add(invalidRequest);
        requestMenuItemsGroup.add(incomeLevels);
        requestMenuItemsGroup.add(indicators);
        requestMenuItemsGroup.add(dataPoints);

        radioButtonMap.put(countries.getModel(), countries);
        radioButtonMap.put(catalogSources.getModel(), catalogSources);
        radioButtonMap.put(invalidRequest.getModel(), invalidRequest);
        radioButtonMap.put(incomeLevels.getModel(), incomeLevels);
        radioButtonMap.put(indicators.getModel(), indicators);
        radioButtonMap.put(dataPoints.getModel(), dataPoints);

        addHelpAbout (menuBar);
    }

    private void addHelpAbout (JMenuBar menuBar) {
        JMenu helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);

        addAPIMenuItem (helpMenu);

        JMenuItem mntmAbout = new JMenuItem("About");
        helpMenu.add(mntmAbout);

        mntmAbout.addActionListener(
            new ActionListener () {

                @Override
                public void actionPerformed(ActionEvent actionEvent) {

                    AboutDialog dialog;

                    try {
                        dialog = new AboutDialog ();
                    } catch (IOException ioException) {
                        throw new RuntimeException("Unable to create the AboutDialog.", ioException);
                    }
                    dialog.setVisible(true);
                }
            }
        );
    }

    private void addAPIMenuItem (JMenu helpMenu) {

        final String destination = "http://bit.ly/2cUuAcy";

        JMenuItem apiJavadocs = new JMenuItem("API Javadocs");

        apiJavadocs.setForeground(Color.blue);

        helpMenu.add(apiJavadocs);

        apiJavadocs.addActionListener(
            new ActionListener () {

                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    // This is for tracking purposes and will direct the user
                    // to http://coherentlogic.com/wbJavaDoc/
                    try {
                        AboutDialog.open(destination);
                    } catch (URISyntaxException uriSyntaxException) {
                        throw new InvalidURIException(
                            "Unable to open the destination: " + destination,
                            uriSyntaxException
                        );
                    }
                }
            }
        );
    }

    /**
     * Method configures the Swing components that are added to this object's
     * JFrame.
     */
    @PostConstruct
    public void initialize () {

        groovyEngine = applicationContext.getBean(GroovyEngine.class);

        queryBuilderFactoryMap = (Map<String, QueryBuilderFactory>)
            applicationContext.getBean("queryBuilderFactoryMap");

        exampleMap = (Map<String, String>) applicationContext.getBean("exampleMap");

        try {
            uri = new URI("https://twitter.com/CoherentMktData");
        } catch (URISyntaxException uriSyntaxException) {
            throw new RuntimeException (uriSyntaxException);
        }

        setTitle("World Bank Client GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JPanel parent = new JPanel();
        parent.setLayout(new BorderLayout()); 

        final JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        parent.add(panel);

        getContentPane().add(parent, BorderLayout.CENTER);
        setExtendedState(Frame.MAXIMIZED_BOTH); 

        JLabel enterYourQueryLabel = new JLabel(
            "Enter your query here (context contains references to: " +
            "queryBuilder):");

        panel.add(enterYourQueryLabel);

        final JTextArea inputTextArea = new JTextArea();

        JScrollPane inputTextAreaScrollPane = new JScrollPane(inputTextArea);

        inputTextAreaScrollPane.
            setVerticalScrollBarPolicy(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        inputTextAreaScrollPane.
        setHorizontalScrollBarPolicy(
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        initializeMenu(inputTextArea);

        String exampleText = exampleMap.get (DATA_POINTS);

        inputTextArea.setText(exampleText);

        inputTextArea.setColumns(80);
        inputTextArea.setRows(40);
        panel.add(inputTextAreaScrollPane);

        panel.add(runScriptButton);

        JLabel outputAppearsBelowLabel = new JLabel(
            "The output appears below:");

        panel.add(outputAppearsBelowLabel);

        outputTextArea.setColumns(80);
        outputTextArea.setRows(40);

        JScrollPane outputTextAreaScrollPane = new JScrollPane(outputTextArea);

        outputTextAreaScrollPane.
            setVerticalScrollBarPolicy(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        panel.add(outputTextAreaScrollPane);

        GraphicsEnvironment env =
            GraphicsEnvironment.getLocalGraphicsEnvironment();

        Rectangle bounds = env.getMaximumWindowBounds();

        setBounds(bounds);

        runScriptButton.addActionListener(
            new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent actionEvent) {

                    String scriptText = inputTextArea.getText();

                    log.info("scriptText:\n\n" + scriptText);

                    ButtonModel buttonModel =
                        requestMenuItemsGroup.getSelection();

                    JRadioButtonMenuItem selectedMenuItem =
                        radioButtonMap.get(buttonModel);

                    String selectedText = selectedMenuItem.getText();

                    QueryBuilderFactory queryBuilderFactory =
                        (QueryBuilderFactory)
                            queryBuilderFactoryMap.get(selectedText);

                    QueryBuilder requestBuilder =
                        queryBuilderFactory.getInstance();

                    AdminRegionDAO adminRegionDAO = applicationContext.getBean(AdminRegionDAO.class);
                    CatalogSourceDAO catalogSourceDAO = applicationContext.getBean(CatalogSourceDAO.class);
                    CatalogSourcesDAO catalogSourcesDAO = applicationContext.getBean(CatalogSourcesDAO.class);
                    CountriesDAO countriesDAO = applicationContext.getBean(CountriesDAO.class);
                    CountryDAO countryDAO = applicationContext.getBean(CountryDAO.class);
                    DataPointCountryDAO dataPointCountryDAO = applicationContext.getBean(DataPointCountryDAO.class);
                    DataPointDAO dataPointDAO = applicationContext.getBean(DataPointDAO.class);
                    DataPointIndicatorDAO dataPointIndicatorDAO =
                        applicationContext.getBean(DataPointIndicatorDAO.class);
                    DataPointsDAO dataPointsDAO = applicationContext.getBean(DataPointsDAO.class);
                    IncomeLevelDAO incomeLevelDAO = applicationContext.getBean(IncomeLevelDAO.class);
                    IncomeLevelsDAO incomeLevelsDAO = applicationContext.getBean(IncomeLevelsDAO.class);
                    IndicatorDAO indicatorDAO = applicationContext.getBean(IndicatorDAO.class);
                    IndicatorsDAO indicatorsDAO = applicationContext.getBean(IndicatorsDAO.class);
                    IndicatorSourceDAO indicatorSourceDAO = applicationContext.getBean(IndicatorSourceDAO.class);
                    IndicatorTopicDAO indicatorTopicDAO = applicationContext.getBean(IndicatorTopicDAO.class);
                    IndicatorTopicsDAO indicatorTopicsDAO = applicationContext.getBean(IndicatorTopicsDAO.class);
                    LendingTypeDAO lendingTypeDAO = applicationContext.getBean(LendingTypeDAO.class);
                    MessageDAO messageDAO = applicationContext.getBean(MessageDAO.class);
                    RegionDAO regionDAO = applicationContext.getBean(RegionDAO.class);
                    SourceDAO sourceDAO = applicationContext.getBean(SourceDAO.class);
                    TopicDAO topicDAO = applicationContext.getBean(TopicDAO.class);
                    TopicsDAO topicsDAO = applicationContext.getBean(TopicsDAO.class);

                    groovyEngine.setVariable(QUERY_BUILDER, requestBuilder);
                    groovyEngine.setVariable(LOG, log);
                    groovyEngine.setVariable("adminRegionDAO", adminRegionDAO);
                    groovyEngine.setVariable("catalogSourceDAO", catalogSourceDAO);
                    groovyEngine.setVariable("catalogSourcesDAO", catalogSourcesDAO);
                    groovyEngine.setVariable("countriesDAO", countriesDAO);
                    groovyEngine.setVariable("countryDAO", countryDAO);
                    groovyEngine.setVariable("dataPointCountryDAO", dataPointCountryDAO);
                    groovyEngine.setVariable("dataPointDAO", dataPointDAO);
                    groovyEngine.setVariable("dataPointIndicatorDAO", dataPointIndicatorDAO);
                    groovyEngine.setVariable("dataPointsDAO", dataPointsDAO);
                    groovyEngine.setVariable("incomeLevelDAO", incomeLevelDAO);
                    groovyEngine.setVariable("incomeLevelsDAO", incomeLevelsDAO);
                    groovyEngine.setVariable("indicatorDAO", indicatorDAO);
                    groovyEngine.setVariable("indicatorsDAO", indicatorsDAO);
                    groovyEngine.setVariable("indicatorSourceDAO", indicatorSourceDAO);
                    groovyEngine.setVariable("indicatorTopicDAO", indicatorTopicDAO);
                    groovyEngine.setVariable("indicatorTopicsDAO", indicatorTopicsDAO);
                    groovyEngine.setVariable("lendingTypeDAO", lendingTypeDAO);
                    groovyEngine.setVariable("messageDAO", messageDAO);
                    groovyEngine.setVariable("regionDAO", regionDAO);
                    groovyEngine.setVariable("sourceDAO", sourceDAO);
                    groovyEngine.setVariable("topicDAO", topicDAO);
                    groovyEngine.setVariable("topicsDAO", topicsDAO);

                    Object result = null;

                    Monitor monitor = MonitorFactory.start(monKey);

                    try {
                        result = groovyEngine.evaluate(scriptText);
                    } catch (Throwable throwable) {

                        log.error("Evaluation failed for the script:\n\n" +
                            scriptText, throwable);

                        JOptionPane.showMessageDialog(
                            panel,
                            throwable.getMessage(),
                            "Evaluation failed!",
                            JOptionPane.ERROR_MESSAGE);

                        return;
                    } finally {
                        monitor.stop();
                        log.info ("JAMon report: " + monitor);
                    }

                    log.info("result: " + result);

                    if (result != null) {
                        String stringifiedResult =
                            objectStringifier.toString(result);

                        String fullResult =
                            "// Note that null values are not indicative of a " +
                            "problem, per se, for \n" +
                            "// example the PrimaryKey is only ever assigned " +
                            "when the object has been \n" +
                            "// saved to a database and since this does not " +
                            "happen in this example.\n\n\n" +
                            stringifiedResult;

                        outputTextArea.setText(fullResult);
                    }
                }
            }
        );
    }

    /**
     * The main method uses the Spring application context to get an instance of
     * {@link WBClientGUI} and then displays this object.
     */
    @Override
    public void run(String... args) throws Exception {
        setVisible(true);
    }

    public static void main (String[] unused) throws InterruptedException {

        try {

            SpringApplicationBuilder builder =
                new SpringApplicationBuilder (WBClientGUI.class);

            builder
                .web(false)
                .headless(false)
                .registerShutdownHook(true)
                .run(unused);

        } catch (Throwable thrown) {
            log.error("ExampleApplication.main caught an exception.", thrown);
        }

        Thread.sleep(Long.MAX_VALUE);

        System.exit(-9999);
    }
}

/**
 * An {@link java.awt.event ActionListener} implementation that adds a given
 * example to the inputTextArea when the user selects a given
 * {@link javax.swing.JMenuItem}.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
class MenuItemSelectedActionListener implements ActionListener {

    private final Map<String, String> exampleMap;

    private final JTextArea inputTextArea;

    public MenuItemSelectedActionListener(
        Map<String, String> exampleMap,
        JTextArea inputTextArea
    ) {
        super();
        this.exampleMap = exampleMap;
        this.inputTextArea = inputTextArea;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        JMenuItem menuItem = (JMenuItem) actionEvent.getSource();

        String selectedMenu = menuItem.getText();

        String example = exampleMap.get(selectedMenu);

        inputTextArea.setText(example);
    }
}


//@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan(basePackages="com.coherentlogic.wb.client")
//public class WBClientGUI extends JFrame implements CommandLineRunner {
//
//    @Override
//    public void run(String... args) throws Exception {
//        setVisible(true);
//    }
//
//    private static final long serialVersionUID = 1L;
//
//    private static final Logger log = LoggerFactory.getLogger(WBClientGUI.class);
//
//    private static final String JAVADOC_URI = "http://bit.ly/19nRX6W";
//
//    private static final String
//        COUNTRIES = "Countries",
//        CATALOG_SOURCES = "CatalogSources",
//        INVALID_REQUEST = "InvalidRequest",
//        INCOME_LEVELS = "IncomeLevels",
//        INDICATORS = "Indicators",
//        DATA_POINTS = "DataPoints";
//
//    private static final String COUNTRIES_QUERY_BUILDER_FACTORY = "countriesQueryBuilderFactory";
//
//    private static final Map<String, String> beanIdMap = new HashMap<String, String> ();
//
//    static {
//        beanIdMap.put(COUNTRIES, COUNTRIES_QUERY_BUILDER_FACTORY);
//    }
//
//    private Map<String, String> exampleMap;
//
////    /**
////     * @throws URISyntaxException 
////     * @throws IOException 
////     * @todo Remove the init method from the constructor.
////     */
////    public WBClientGUI(
////        GroovyEngine groovyEngine,
////        Map<String, ? extends QueryBuilderFactory> queryBuilderFactoryMap,
////        Map<String, String> exampleMap
////    ) throws URISyntaxException, IOException {
////        super (
////            groovyEngine,
////            queryBuilderFactoryMap,
////            exampleMap,
////            JAVADOC_URI,
////            createAboutDialog ()
////        );
////
////        this.exampleMap = exampleMap;
////
////        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////    }
//
//    @PostConstruct
//    public void initialize () {
//        
//        this.ab
//        
//    }
//
//
//    @Override
//    protected void initializeMenu (JTextArea inputTextArea) {
//        JMenuBar menuBar = new JMenuBar();
//        setJMenuBar(menuBar);
//
//        JMenu mnRequest = new JMenu("Examples");
//        menuBar.add(mnRequest);
//
//        JRadioButtonMenuItem countries = new JRadioButtonMenuItem(COUNTRIES);
//        countries.setSelected(true);
//        mnRequest.add(countries);
//
//        countries.addActionListener(
//            new MenuItemSelectedActionListener (exampleMap, inputTextArea));
//
//        JRadioButtonMenuItem catalogSources =
//            new JRadioButtonMenuItem(CATALOG_SOURCES);
//        mnRequest.add(catalogSources);
//
//        catalogSources.addActionListener(
//            new MenuItemSelectedActionListener (exampleMap, inputTextArea));
//
//        JRadioButtonMenuItem invalidRequest =
//            new JRadioButtonMenuItem(INVALID_REQUEST);
//        mnRequest.add(invalidRequest);
//
//        invalidRequest.addActionListener(
//            new MenuItemSelectedActionListener (exampleMap, inputTextArea));
//
//        JRadioButtonMenuItem incomeLevels =
//            new JRadioButtonMenuItem(INCOME_LEVELS);
//        mnRequest.add(incomeLevels);
//
//        incomeLevels.addActionListener(
//            new MenuItemSelectedActionListener (exampleMap, inputTextArea));
//
//        JRadioButtonMenuItem indicators =
//            new JRadioButtonMenuItem(INDICATORS);
//        mnRequest.add(indicators);
//
//        indicators.addActionListener(
//            new MenuItemSelectedActionListener (exampleMap, inputTextArea));
//
//        JRadioButtonMenuItem dataPoints =
//            new JRadioButtonMenuItem(DATA_POINTS);
//        mnRequest.add(dataPoints);
//
//        dataPoints.addActionListener(
//            new MenuItemSelectedActionListener (exampleMap, inputTextArea));
//
//        getRequestMenuItemsGroup().add(countries);
//        getRequestMenuItemsGroup().add(catalogSources);
//        getRequestMenuItemsGroup().add(invalidRequest);
//        getRequestMenuItemsGroup().add(incomeLevels);
//        getRequestMenuItemsGroup().add(indicators);
//        getRequestMenuItemsGroup().add(dataPoints);
//
//        final Map<ButtonModel, JRadioButtonMenuItem> radioButtonMap =
//            getRadioButtonMap ();
//
//        radioButtonMap.put(countries.getModel(), countries);
//        radioButtonMap.put(catalogSources.getModel(), catalogSources);
//        radioButtonMap.put(invalidRequest.getModel(), invalidRequest);
//        radioButtonMap.put(incomeLevels.getModel(), incomeLevels);
//        radioButtonMap.put(indicators.getModel(), indicators);
//        radioButtonMap.put(dataPoints.getModel(), dataPoints);
//
//        addHelpAbout (menuBar);
//    }
//
//    @Override
//    protected String getApplicationTitle() {
//        return "World Bank Client GUI";
//    }
//
//    @Override
//    protected String getDefaultExampleApplicationText() {
//        return exampleMap.get (COUNTRIES);
//    }
//
//    private static final String WB_CLIENT_GUI = "wbClientGUI";
//}