package com.uttesh.seleniumflash.common;

/**
 * @author Uttesh Kumar T.H.
 */
public interface Constants {

    enum OPTIONS {

        RIGHT, LEFT, ABOVE, BELOW
    }

    enum KEYS {

        TAB, ENTER, ESC, BACKSPACE
    }

    interface Images {

        interface WeChooseMoon {
            String START_BUTTON = "\\images\\wechoosemoon\\start1.png";
            String MAILING_MENU = "\\images\\wechoosemoon\\mailing.png";
            String FIRST_NAME_FIELD = "\\images\\wechoosemoon\\firstName.png";
            String LAST_NAME_FIELD = "\\images\\wechoosemoon\\lastName.png";
            String BIRTH_YEAR_FIELD = "\\images\\wechoosemoon\\birthYear.png";
            String SUBMIT_BUTTON = "\\images\\wechoosemoon\\submitButton.png";
            String SOUND = "\\images\\wechoosemoon\\sound.png";
        }
        
        interface WaterLife{
            String ENTER_BUTTON = "\\images\\waterlife\\enter.png";
            String WATER_IS_MENU = "\\images\\waterlife\\water_is.png";
            String FISHING_MENU = "\\images\\waterlife\\fishing.png";
        }

    }
}
