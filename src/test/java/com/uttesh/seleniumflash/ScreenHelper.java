/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uttesh.seleniumflash;

import com.uttesh.seleniumflash.common.Constants;
import org.apache.log4j.Logger;
import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

/**
 *
 * @author Uttesh Kumar T.H.
 */
public class ScreenHelper {

    final static Logger logger = Logger.getLogger(ScreenHelper.class);
    Screen screen = new Screen();

    public ScreenHelper() {
        Settings.OcrTextRead = true;
    }

    public void click() {
        try {
            screen.click();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Screen getScreen() {
        return screen;
    }
    

    public void click(String image) {
        try {
            Pattern pattern = new Pattern(image);
            Match urlField = screen.wait(pattern, 2000);
            urlField.click(pattern);
        } catch (Exception exception) {
            logger.error("screen helper click", exception);
        }
    }
    public void mouseover(String image) {
        try {
            System.out.println("mouse over");
            Pattern pattern = new Pattern(image);
            Match urlField = screen.wait(pattern, 2000);
            urlField.mouseMove(image);
        } catch (Exception exception) {
            logger.error("screen helper mouse move", exception);
        }
    }

    public void subElementClick(String parent, String child) {
        try {
            Match match = getMatch(parent);
            match.find(child).click();
        } catch (Exception exception) {
            logger.error("clickRegion helper click", exception);
        }
    }

    public void clickRegion(String component1, String component2, Constants.OPTIONS options) {
        Match match = getMatch(component1);
        try {
            switch (options) {
                case RIGHT:
                    match.right().find(component2).click();
                    break;
                case LEFT:
                    match.left().find(component2).click();
                    break;
                case ABOVE:
                    match.above().find(component2).click();
                    break;
                case BELOW:
                    match.below().find(component2).click();
                    break;
            }
        } catch (Exception exception) {
            logger.error("clickRegion helper click", exception);
        }
    }

    public void inputText(String text) {
        try {
            screen.type(text);
        } catch (Exception exception) {
            logger.error("screen helper click", exception);
        }
    }

    public void pressKey(Constants.KEYS key) {
        switch (key) {
            case TAB:
                screen.type(Key.TAB);
                break;
            case ENTER:
                screen.type(Key.ENTER);
                break;
            case ESC:
                screen.type(Key.ESC);
                break;
            case BACKSPACE:
                screen.type(Key.BACKSPACE);
                break;
        }
    }

    public String getText(String component, Constants.OPTIONS options) throws FindFailed {
        Match match = getMatch(component);
        Region region = null;
        switch (options) {
            case RIGHT:
                region = match.right();
                break;
            case LEFT:
                region = match.left();
                break;
            case ABOVE:
                region = match.above();
                break;
            case BELOW:
                region = match.below();
                break;
        }
        return region == null ? "NO DATA" : region.text();
    }

    public Match getMatch(String component) {
        Match match = null;
        try {
            Pattern pattern = new Pattern(component);
            match = screen.find(pattern);
        } catch (Exception exception) {
            logger.error("getMatch ", exception);
        }
        return match;
    }
}
