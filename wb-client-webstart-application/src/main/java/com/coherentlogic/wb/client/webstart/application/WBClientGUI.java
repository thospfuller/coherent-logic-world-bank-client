package com.coherentlogic.wb.client.webstart.application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
import com.coherentlogic.coherent.data.adapter.core.exceptions.InvalidURIException;
import com.coherentlogic.wb.client.core.builders.QueryBuilder;
import com.coherentlogic.wb.client.db.integration.services.AdminRegionService;
import com.coherentlogic.wb.client.db.integration.services.CatalogSourceService;
import com.coherentlogic.wb.client.db.integration.services.CatalogSourcesService;
import com.coherentlogic.wb.client.db.integration.services.CountriesService;
import com.coherentlogic.wb.client.db.integration.services.CountryService;
import com.coherentlogic.wb.client.db.integration.services.DataPointCountryService;
import com.coherentlogic.wb.client.db.integration.services.DataPointIndicatorService;
import com.coherentlogic.wb.client.db.integration.services.DataPointService;
import com.coherentlogic.wb.client.db.integration.services.DataPointsService;
import com.coherentlogic.wb.client.db.integration.services.IncomeLevelService;
import com.coherentlogic.wb.client.db.integration.services.IncomeLevelsService;
import com.coherentlogic.wb.client.db.integration.services.IndicatorService;
import com.coherentlogic.wb.client.db.integration.services.IndicatorSourceService;
import com.coherentlogic.wb.client.db.integration.services.IndicatorTopicService;
import com.coherentlogic.wb.client.db.integration.services.IndicatorTopicsService;
import com.coherentlogic.wb.client.db.integration.services.IndicatorsService;
import com.coherentlogic.wb.client.db.integration.services.LendingTypeService;
import com.coherentlogic.wb.client.db.integration.services.MessageService;
import com.coherentlogic.wb.client.db.integration.services.RegionService;
import com.coherentlogic.wb.client.db.integration.services.SourceService;
import com.coherentlogic.wb.client.db.integration.services.TopicService;
import com.coherentlogic.wb.client.db.integration.services.TopicsService;
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

    private static final String
        COUNTRIES = "Countries",
        CATALOG_SOURCES = "CatalogSources",
        INVALID_REQUEST = "InvalidRequest",
        INCOME_LEVELS = "IncomeLevels",
        INDICATORS = "Indicators",
        INDICATORS2 = "Indicators2",
        DATA_POINTS = "DataPoints",
        QUERY_BUILDER = "queryBuilder",
        LOG = "log";

    private final JTextArea outputTextArea = new JTextArea();

    private final JButton runScriptButton = new JButton("Run script");

    private final ButtonGroup requestMenuItemsGroup = new ButtonGroup();

    private final Map<ButtonModel, JRadioButtonMenuItem> radioButtonMap =
        new HashMap<ButtonModel, JRadioButtonMenuItem> ();

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
        countries.setSelected(true);
        mnRequest.add(countries);

        countries.addActionListener(new MenuItemSelectedActionListener (exampleMap, inputTextArea));

        JRadioButtonMenuItem catalogSources = new JRadioButtonMenuItem(CATALOG_SOURCES);
        mnRequest.add(catalogSources);

        catalogSources.addActionListener(new MenuItemSelectedActionListener (exampleMap, inputTextArea));

        JRadioButtonMenuItem invalidRequest =new JRadioButtonMenuItem(INVALID_REQUEST);
        mnRequest.add(invalidRequest);

        invalidRequest.addActionListener(new MenuItemSelectedActionListener (exampleMap, inputTextArea));

        JRadioButtonMenuItem incomeLevels = new JRadioButtonMenuItem(INCOME_LEVELS);
        mnRequest.add(incomeLevels);

        incomeLevels.addActionListener(new MenuItemSelectedActionListener (exampleMap, inputTextArea));

        JRadioButtonMenuItem indicators = new JRadioButtonMenuItem(INDICATORS);
        mnRequest.add(indicators);

        indicators.addActionListener(new MenuItemSelectedActionListener (exampleMap, inputTextArea));

        JRadioButtonMenuItem indicators2 = new JRadioButtonMenuItem(INDICATORS2);
        mnRequest.add(indicators2);

        indicators2.addActionListener(new MenuItemSelectedActionListener (exampleMap, inputTextArea));

        JRadioButtonMenuItem dataPoints = new JRadioButtonMenuItem(DATA_POINTS);
        mnRequest.add(dataPoints);

        dataPoints.addActionListener(new MenuItemSelectedActionListener (exampleMap, inputTextArea));

        requestMenuItemsGroup.add(countries);
        requestMenuItemsGroup.add(catalogSources);
        requestMenuItemsGroup.add(invalidRequest);
        requestMenuItemsGroup.add(incomeLevels);
        requestMenuItemsGroup.add(indicators);
        requestMenuItemsGroup.add(indicators2);
        requestMenuItemsGroup.add(dataPoints);

        radioButtonMap.put(countries.getModel(), countries);
        radioButtonMap.put(catalogSources.getModel(), catalogSources);
        radioButtonMap.put(invalidRequest.getModel(), invalidRequest);
        radioButtonMap.put(incomeLevels.getModel(), incomeLevels);
        radioButtonMap.put(indicators.getModel(), indicators);
        radioButtonMap.put(indicators2.getModel(), indicators2);
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

        exampleMap = (Map<String, String>) applicationContext.getBean("exampleMap");

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
            "Enter your query here (context contains references to: queryBuilder):");

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

        String exampleText = exampleMap.get (COUNTRIES);

        inputTextArea.setText(exampleText);

        inputTextArea.setColumns(80);
        inputTextArea.setRows(40);
        panel.add(inputTextAreaScrollPane);

        panel.add(runScriptButton);

        JLabel outputAppearsBelowLabel = new JLabel("The output appears below:");

        panel.add(outputAppearsBelowLabel);

        outputTextArea.setColumns(80);
        outputTextArea.setRows(40);

        JScrollPane outputTextAreaScrollPane = new JScrollPane(outputTextArea);

        outputTextAreaScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        panel.add(outputTextAreaScrollPane);

        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();

        Rectangle bounds = env.getMaximumWindowBounds();

        setBounds(bounds);

        runScriptButton.addActionListener(
            new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent actionEvent) {

                    String scriptText = inputTextArea.getText();

                    QueryBuilder queryBuilder = applicationContext.getBean(QueryBuilder.class);

                    GroovyEngine groovyEngine = applicationContext.getBean(GroovyEngine.class);

                    AdminRegionService adminRegionService = applicationContext.getBean(AdminRegionService.class);
                    CatalogSourceService catalogSourceService = applicationContext.getBean(CatalogSourceService.class);
                    CatalogSourcesService catalogSourcesService = applicationContext.getBean(CatalogSourcesService.class);
                    CountriesService countriesService = applicationContext.getBean(CountriesService.class);
                    CountryService countryService = applicationContext.getBean(CountryService.class);
                    DataPointCountryService dataPointCountryService = applicationContext.getBean(DataPointCountryService.class);
                    DataPointService dataPointService = applicationContext.getBean(DataPointService.class);
                    DataPointIndicatorService dataPointIndicatorService =
                        applicationContext.getBean(DataPointIndicatorService.class);
                    DataPointsService dataPointsService = applicationContext.getBean(DataPointsService.class);
                    IncomeLevelService incomeLevelService = applicationContext.getBean(IncomeLevelService.class);
                    IncomeLevelsService incomeLevelsService = applicationContext.getBean(IncomeLevelsService.class);
                    IndicatorService indicatorService = applicationContext.getBean(IndicatorService.class);
                    IndicatorsService indicatorsService = applicationContext.getBean(IndicatorsService.class);
                    IndicatorSourceService indicatorSourceService = applicationContext.getBean(IndicatorSourceService.class);
                    IndicatorTopicService indicatorTopicService = applicationContext.getBean(IndicatorTopicService.class);
                    IndicatorTopicsService indicatorTopicsService = applicationContext.getBean(IndicatorTopicsService.class);
                    LendingTypeService lendingTypeService = applicationContext.getBean(LendingTypeService.class);
                    MessageService messageService = applicationContext.getBean(MessageService.class);
                    RegionService regionService = applicationContext.getBean(RegionService.class);
                    SourceService sourceService = applicationContext.getBean(SourceService.class);
                    TopicService topicService = applicationContext.getBean(TopicService.class);
                    TopicsService topicsService = applicationContext.getBean(TopicsService.class);

                    groovyEngine.setVariable(QUERY_BUILDER, queryBuilder);
                    groovyEngine.setVariable(LOG, log);
                    groovyEngine.setVariable("adminRegionService", adminRegionService);
                    groovyEngine.setVariable("catalogSourceService", catalogSourceService);
                    groovyEngine.setVariable("catalogSourcesService", catalogSourcesService);
                    groovyEngine.setVariable("countriesService", countriesService);
                    groovyEngine.setVariable("countryService", countryService);
                    groovyEngine.setVariable("dataPointCountryService", dataPointCountryService);
                    groovyEngine.setVariable("dataPointService", dataPointService);
                    groovyEngine.setVariable("dataPointIndicatorService", dataPointIndicatorService);
                    groovyEngine.setVariable("dataPointsService", dataPointsService);
                    groovyEngine.setVariable("incomeLevelService", incomeLevelService);
                    groovyEngine.setVariable("incomeLevelsService", incomeLevelsService);
                    groovyEngine.setVariable("indicatorService", indicatorService);
                    groovyEngine.setVariable("indicatorsService", indicatorsService);
                    groovyEngine.setVariable("indicatorSourceService", indicatorSourceService);
                    groovyEngine.setVariable("indicatorTopicService", indicatorTopicService);
                    groovyEngine.setVariable("indicatorTopicsService", indicatorTopicsService);
                    groovyEngine.setVariable("lendingTypeService", lendingTypeService);
                    groovyEngine.setVariable("messageService", messageService);
                    groovyEngine.setVariable("regionService", regionService);
                    groovyEngine.setVariable("sourceService", sourceService);
                    groovyEngine.setVariable("topicService", topicService);
                    groovyEngine.setVariable("topicsService", topicsService);

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
                            "// Note that null values are not indicative of a problem, per se, for \n" +
                            "// example the PrimaryKey is only ever assigned when the object has been \n" +
                            "// saved to a database and since this does not happen in this example.\n\n\n" +
                            "//\n" +
                            "// -----\n" +
                            "//\n" +
                            "// JAMON Performance Metrics:\n" +
                            "//\n" +
                            "// " + monitor + "\n" +
                            "//\n" +
                            "// -----\n" +
                            "//\n\n\n" +
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

        java.awt.EventQueue.invokeLater(
            () -> {
                toFront();
                repaint();
            }
        );
    }

    public static void main (String[] unused) throws Exception {

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
