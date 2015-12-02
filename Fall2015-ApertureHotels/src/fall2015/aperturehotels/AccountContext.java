/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fall2015.aperturehotels;

/**
 *
 * @author Iwasaki
 */
public class AccountContext {
    private final static AccountContext instance = new AccountContext();

    public static AccountContext getInstance() {
        return instance;
    }

    private CurrentAccount country = new CurrentAccount();

    public CurrentAccount currentCountry() {
        return country;
    }
}