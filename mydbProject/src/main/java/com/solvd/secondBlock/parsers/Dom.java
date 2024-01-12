package com.solvd.secondBlock.parsers;

import com.solvd.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Dom {
    static {
        System.setProperty("log4j2.configurationFile", "src/main/resources/log4j2.xml");
    }

    private final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        File file = new File("src/main/resources/parsers/olympics.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(file);

        document.getDocumentElement().normalize();

        LOGGER.info("Root Element :" + document.getDocumentElement().getNodeName());
        LOGGER.info("------");

        NodeList list = document.getElementsByTagName("sports");

        for (int i = 0; i < list.getLength(); i++) {
            Node sportNode = list.item(i);

            if (sportNode.getNodeType() == Node.ELEMENT_NODE) {
                Element sportElement = (Element) sportNode;

                String sportId = sportElement.getElementsByTagName("id").item(0).getTextContent();
                String sportName = sportElement.getElementsByTagName("name").item(0).getTextContent();
                String sportDescription = sportElement.getElementsByTagName("description").item(0).getTextContent();

                Element sportTypeElement = (Element) sportElement.getElementsByTagName("sportType").item(0);
                String sportTypeId = sportTypeElement.getElementsByTagName("id").item(0).getTextContent();
                String sportTypeName = sportTypeElement.getElementsByTagName("name").item(0).getTextContent();
                String isIndividual = sportTypeElement.getElementsByTagName("isIndividual").item(0).getTextContent();

                LOGGER.info("Sport ID: " + sportId);
                LOGGER.info("Sport Name: " + sportName);
                LOGGER.info("Sport Description: " + sportDescription);
                LOGGER.info("Sport Type ID: " + sportTypeId);
                LOGGER.info("Sport Type Name: " + sportTypeName);
                LOGGER.info("Is Individual: " + isIndividual);
            }
        }

        LOGGER.info("------");

        NodeList teamsList = document.getElementsByTagName("team");
        for (int i = 0; i < teamsList.getLength(); i++) {
            Node teamNode = teamsList.item(i);

            if (teamNode.getNodeType() == Node.ELEMENT_NODE) {
                Element teamElement = (Element) teamNode;

                String teamId = teamElement.getElementsByTagName("id").item(0).getTextContent();
                String teamName = teamElement.getElementsByTagName("teamName").item(0).getTextContent();
                String squadSize = teamElement.getElementsByTagName("squadSize").item(0).getTextContent();

                LOGGER.info("Team ID: " + teamId);
                LOGGER.info("Team Name: " + teamName);
                LOGGER.info("Squad Size: " + squadSize);


                Element captainElement = (Element) teamElement.getElementsByTagName("captain").item(0);
                String captainId = captainElement.getElementsByTagName("id").item(0).getTextContent();
                String captainName = captainElement.getElementsByTagName("pname").item(0).getTextContent();
                String captainSurname = captainElement.getElementsByTagName("surname").item(0).getTextContent();
                String captainBirthdate = captainElement.getElementsByTagName("birthdate").item(0).getTextContent();
                String captainGender = captainElement.getElementsByTagName("gender").item(0).getTextContent();
                String captainEmail = captainElement.getElementsByTagName("email").item(0).getTextContent();

                LOGGER.info("Captain ID: " + captainId);
                LOGGER.info("Captain Name: " + captainName);
                LOGGER.info("Captain Surname: " + captainSurname);
                LOGGER.info("Captain Birthdate: " + captainBirthdate);
                LOGGER.info("Captain Gender: " + captainGender);
                LOGGER.info("Captain Email: " + captainEmail);


                NodeList playersList = teamElement.getElementsByTagName("participant");
                for (int j = 0; j < playersList.getLength(); j++) {
                    Node playerNode = playersList.item(j);

                    if (playerNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element playerElement = (Element) playerNode;

                        String playerId = playerElement.getElementsByTagName("id").item(0).getTextContent();
                        String playerName = playerElement.getElementsByTagName("pname").item(0).getTextContent();
                        String playerSurname = playerElement.getElementsByTagName("surname").item(0).getTextContent();
                        String playerBirthdate = playerElement.getElementsByTagName("birthdate").item(0).getTextContent();
                        String playerGender = playerElement.getElementsByTagName("gender").item(0).getTextContent();
                        String playerEmail = playerElement.getElementsByTagName("email").item(0).getTextContent();

                        LOGGER.info("  Player ID: " + playerId);
                        LOGGER.info("  Player Name: " + playerName);
                        LOGGER.info("  Player Surname: " + playerSurname);
                        LOGGER.info("  Player Birthdate: " + playerBirthdate);
                        LOGGER.info("  Player Gender: " + playerGender);
                        LOGGER.info("  Player Email: " + playerEmail);

                        NodeList playerIndividualScoreList = playerElement.getElementsByTagName("individualScore");
                        for (int k = 0; k < playerIndividualScoreList.getLength(); k++) {
                            Node individualScoreNode = playerIndividualScoreList.item(k);

                            if (individualScoreNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element individualScoreElement = (Element) individualScoreNode;

                                String scoreId = individualScoreElement.getElementsByTagName("id").item(0).getTextContent();
                                String time = individualScoreElement.getElementsByTagName("time").item(0).getTextContent();
                                String points = individualScoreElement.getElementsByTagName("points").item(0).getTextContent();
                                String distance = individualScoreElement.getElementsByTagName("distance").item(0).getTextContent();

                                LOGGER.info("    Individual Score ID: " + scoreId);
                                LOGGER.info("    Time: " + time);
                                LOGGER.info("    Points: " + points);
                                LOGGER.info("    Distance: " + distance);
                            }
                        }
                    }
                }

                NodeList teamScoreList = teamElement.getElementsByTagName("teamScoreList");
                for (int j = 0; j < teamScoreList.getLength(); j++) {
                    Node teamScoreNode = teamScoreList.item(j);

                    if (teamScoreNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element teamScoreElement = (Element) teamScoreNode;


                        NodeList scoresList = teamScoreElement.getElementsByTagName("teamScore");
                        for (int k = 0; k < scoresList.getLength(); k++) {
                            Node scoreNode = scoresList.item(k);

                            if (scoreNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element scoreElement = (Element) scoreNode;

                                String scoreId = scoreElement.getElementsByTagName("id").item(0).getTextContent();
                                String teamPoints = scoreElement.getElementsByTagName("teamPoints").item(0).getTextContent();
                                String teamTime = scoreElement.getElementsByTagName("teamTime").item(0).getTextContent();

                                LOGGER.info("Team Score ID: " + scoreId);
                                LOGGER.info("Team Points: " + teamPoints);
                                LOGGER.info("Team Time: " + teamTime);
                            }
                        }
                    }
                }
            }
        }
    }
}
