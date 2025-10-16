package service;

import model.Password;

public class PasswordValidator {

    public boolean esValida(Password password) {
        String valor = password.getValue();
        return tieneLongitudValida(valor) && contieneNumero(valor);
    }

    private boolean tieneLongitudValida(String valor) {
        return valor.length() >= 8;
    }

    private boolean contieneNumero(String valor) {
        return valor.matches(".*\\d.*");
    }
}
