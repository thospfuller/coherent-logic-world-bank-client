package com.coherentlogic.wb.client.webstart.application;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.coherentlogic.coherent.data.model.core.exceptions.InvalidURIException;

/**
 * 
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class AboutDialog extends JDialog {

    private static final Logger log =
        LoggerFactory.getLogger(AboutDialog.class);

    private static final String TWITTER_URL =
        "https://twitter.com/CoherentMktData";

    public AboutDialog() throws IOException {
        init();
    }

    private static JLabel newLabel (String text) {
        JLabel result = new JLabel(text);
        result.setFont(new Font("Arial", Font.BOLD, 13));
        result.setAlignmentX(0.5f);

        return result;
    }

    public static void open(String uri) throws URISyntaxException {
        open (new URI (uri));
    }

    private static void open(URI uri) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(uri);
            } catch (IOException ioException) {
                throw new RuntimeException(
                    "Unable to open the uri " + uri, ioException);
            }
        } else {
            log.warn("The desktop is not supported so the uri '" + uri +
                "' will not be browsed.");
        }
    }

    public final void init() throws IOException {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(Box.createRigidArea(new Dimension(0, 10)));

        ImageIcon icon = new ImageIcon("logo-small.png");
        JLabel label = new JLabel(icon);
        label.setAlignmentX(0.5f);
        add(label);

        add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel blank = newLabel("");

        JLabel name = newLabel(
            "Coherent Logic World Bank Client GUI version 1.0.6-RELEASE");
        JLabel copyright = newLabel(
            "Copyright (C) 2012 - Present Coherent Logic Limited; All Rights " +
            "Reserved.");
        JLabel license = newLabel(
            "Licensed under the GNU Lesser General Public License");
        JLabel follow = newLabel(
            "Follow us on Twitter at:");

        JLabel link = newLabel(TWITTER_URL);
        link.setForeground(Color.blue);

        link.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        link.addMouseListener(
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        open (TWITTER_URL);
                    } catch (URISyntaxException uriSyntaxException) {
                        throw new InvalidURIException (
                            "The uri '" + TWITTER_URL +
                            "' could not be opened.", uriSyntaxException);
                    }
                }
            }
        );

        add(name);
        add(license);
        add(copyright);
        add(blank);
        add(follow);
        add(link);

        add(Box.createRigidArea(new Dimension(0, 50)));

        JButton close = new JButton("Close");
        close.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                dispose();
            }
        });

        close.setAlignmentX(0.5f);
        add(close);

        setModalityType(ModalityType.APPLICATION_MODAL);

        setTitle("About the World Bank Client GUI");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 300);
    }
}
