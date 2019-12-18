package com.infoshare.academy.highfive.consolmenu;

import com.infoshare.academy.highfive.tool.ColorsSet;
import com.infoshare.academy.highfive.tool.TerminalCleaner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

class ConfigurationMenu extends MainMenu {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void runSubmenu() throws Exception {

        ConfigurationMenu configurationMenu = new ConfigurationMenu();
        configurationMenu.menuOptionsDisplay();
        configurationMenu.getUserChoice();
    }

    @Override
    void menuOptionsDisplay() {

        TerminalCleaner.cleanTerminal();

        stdout.info(ColorsSet.ANSI_YELLOW + ">>>>> " + mainMenuTitle + " / " + configurationMenuTitle +" / \n" + ColorsSet.ANSI_RESET);

        menuOptions.add(configurationMenuTitle);
        menuOptions.add("Change DATE format");
        menuOptions.add("Change employees SORTING mode");
        menuOptions.add("Change configuration of external file");
        menuOptions.add("Previous menu");

        stdout.info("\n\n" + menuOptions.get(0) + "\n\n");

        for (int i = 1; i < menuOptions.size(); i++) {

            stdout.info(i + ": " + menuOptions.get(i) + "\n");
        }
    }

    @Override
    int getUserChoice() throws Exception {

        boolean matchedToPattern;
        stdout.info("\n" + "Choose option from 1 to " + (menuOptions.size() - 1) + "\n");
        Scanner scanner = new Scanner(System.in);
        String numberPattern = "[0-9]";
        userChoiceString = scanner.nextLine();
        matchedToPattern = userChoiceString.matches(numberPattern);
        if (!matchedToPattern) {
            stdout.info("Wrong input - try again\n");
            getUserChoice();
        }
        userChoice = Integer.parseInt(userChoiceString);

        if (userChoice > menuOptions.size() - 1 || userChoice == 0) {
            stdout.info("Wrong input - try again\n");
            getUserChoice();
        } else {
            switch (userChoice) {
                case 1:
                    stdout.info("\nChange DATE format - UNDER CONSTRUCTION\n\n");
                    break;
                case 2:
                    stdout.info("\nChange employees SORTING mode - UNDER CONSTRUCTION\n\n");
                    break;
                case 3:
                    stdout.info("\nChange configuration of external file - UNDER CONSTRUCTION\n\n");
                    break;
                default:
                    MainMenu.runMenu();
            }
        }
        return userChoice;
    }
}