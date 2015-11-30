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
public class CurrentAccount {
private String acc_name = "";

//Constructor
public CurrentAccount() {
}

//GETTERS
public String getCurrentAccount() {
    return acc_name;
}

//SETTERS
public void setCurrentAccount(String value) {
    acc_name = value;
}

@Override
public String toString() {
    return getCurrentAccount();
}
}