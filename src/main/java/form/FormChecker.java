/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Amelie Solanas Pruvost
 */
public abstract class FormChecker<T> {

    protected Map<String, String> errors;
    protected HttpServletRequest request;

    public FormChecker(HttpServletRequest request) {
        this.errors = new HashMap<>();
        this.request = request;
    }

    public abstract T checkForm();

    public Map<String, String> getErrors() {
        return errors;
    }

    protected void setError(String key, String value) {
        this.errors.put(key, value);
    }

    protected String getParameter(String key) {
        return request.getParameter(key)
                == null ? "" : request.getParameter(key);
    }

}
