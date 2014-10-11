package com.coherentlogic.wb.client.webstart.application;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.coherentlogic.coherent.data.model.demo.application.AboutDialog.newLabel;
import com.coherentlogic.coherent.data.model.demo.application.AboutDialog;
import com.coherentlogic.coherent.data.model.demo.application.ClientGUI;
import com.coherentlogic.coherent.data.model.demo.application.GroovyEngine;
import com.coherentlogic.coherent.data.model.demo.application.MenuItemSelectedActionListener;
import com.coherentlogic.wb.client.core.builders.QueryBuilder;
import com.coherentlogic.wb.client.core.factories.QueryBuilderFactory;

/**
 * The front-end for the World Bank Client that allows users to directly work
 * with the {@link com.coherentlogic.fred.client.core.builders.QueryBuilder}. 
 *
 * @author <a href="support@coherentlogic.com">Support</a>
 */
public class WBClientGUI extends ClientGUI<QueryBuilder> {

    private static final long serialVersionUID = 1L;

    private static final Logger log =
        LoggerFactory.getLogger(WBClientGUI.class);

    private static final String JAVADOC_URI = "http://bit.ly/19nRX6W";

    private static final String
        COUNTRIES = "Countries",
        CATALOG_SOURCES = "CatalogSources",
        INVALID_REQUEST = "InvalidRequest",
        INCOME_LEVELS = "IncomeLevels",
        INDICATORS = "Indicators",
        DATA_POINTS = "DataPoints";

    private static final String
        COUNTRIES_QUERY_BUILDER_FACTORY = "countriesQueryBuilderFactory";

    private static final Map<String, String> beanIdMap =
        new HashMap<String, String> ();

    static {
        beanIdMap.put(COUNTRIES, COUNTRIES_QUERY_BUILDER_FACTORY);
    }

    private final Map<String, String> exampleMap;

    private static AboutDialog createAboutDialog () throws IOException {
       return new AboutDialog(
           "About the World Bank Client",
           new JLabel[] {
               newLabel("Coherent Logic World Bank Client GUI version 1.0.1"),
               newLabel(
                   "Copyright (C) 2012 - Present Coherent Logic Limited; All " +
                   "Rights Reserved."),
               newLabel(
                   "Licensed under the GNU Lesser General Public License")
           }
       );
   }

    /**
     * @throws URISyntaxException 
     * @throws IOException 
     * @todo Remove the init method from the constructor.
     */
    public WBClientGUI(
        GroovyEngine groovyEngine,
        Map<String, QueryBuilderFactory> queryBuilderFactoryMap,
        Map<String, String> exampleMap
    ) throws URISyntaxException, IOException {
        super (
            groovyEngine,
            queryBuilderFactoryMap,
            exampleMap,
            JAVADOC_URI,
            createAboutDialog ()
        );

        this.exampleMap = exampleMap;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * @see #initialize()
     */
    @Override
    protected void initializeMenu (JTextArea inputTextArea) {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnRequest = new JMenu("Examples");
        menuBar.add(mnRequest);

        JRadioButtonMenuItem countries = new JRadioButtonMenuItem(COUNTRIES);
        countries.setSelected(true);
        mnRequest.add(countries);

        countries.addActionListener(
            new MenuItemSelectedActionListener (exampleMap, inputTextArea));

        JRadioButtonMenuItem catalogSources =
            new JRadioButtonMenuItem(CATALOG_SOURCES);
        mnRequest.add(catalogSources);

        catalogSources.addActionListener(
            new MenuItemSelectedActionListener (exampleMap, inputTextArea));

        JRadioButtonMenuItem invalidRequest =
            new JRadioButtonMenuItem(INVALID_REQUEST);
        mnRequest.add(invalidRequest);

        invalidRequest.addActionListener(
            new MenuItemSelectedActionListener (exampleMap, inputTextArea));

        JRadioButtonMenuItem incomeLevels =
            new JRadioButtonMenuItem(INCOME_LEVELS);
        mnRequest.add(incomeLevels);

        incomeLevels.addActionListener(
            new MenuItemSelectedActionListener (exampleMap, inputTextArea));

        JRadioButtonMenuItem indicators =
            new JRadioButtonMenuItem(INDICATORS);
        mnRequest.add(indicators);

        indicators.addActionListener(
            new MenuItemSelectedActionListener (exampleMap, inputTextArea));

        JRadioButtonMenuItem dataPoints =
            new JRadioButtonMenuItem(DATA_POINTS);
        mnRequest.add(dataPoints);

        dataPoints.addActionListener(
            new MenuItemSelectedActionListener (exampleMap, inputTextArea));

        getRequestMenuItemsGroup().add(countries);
        getRequestMenuItemsGroup().add(catalogSources);
        getRequestMenuItemsGroup().add(invalidRequest);
        getRequestMenuItemsGroup().add(incomeLevels);
        getRequestMenuItemsGroup().add(indicators);
        getRequestMenuItemsGroup().add(dataPoints);

        final Map<ButtonModel, JRadioButtonMenuItem> radioButtonMap =
            getRadioButtonMap ();

        radioButtonMap.put(countries.getModel(), countries);
        radioButtonMap.put(catalogSources.getModel(), catalogSources);
        radioButtonMap.put(invalidRequest.getModel(), invalidRequest);
        radioButtonMap.put(incomeLevels.getModel(), incomeLevels);
        radioButtonMap.put(indicators.getModel(), indicators);
        radioButtonMap.put(dataPoints.getModel(), dataPoints);

        addHelpAbout (menuBar);
    }

    @Override
    protected String getApplicationTitle() {
        return "World Bank Client GUI";
    }

    @Override
    protected String getDefaultExampleApplicationText() {
        return exampleMap.get (COUNTRIES);
    }
}
