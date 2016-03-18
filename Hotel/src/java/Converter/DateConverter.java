/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.apache.struts2.util.StrutsTypeConverter;
import com.opensymphony.xwork2.conversion.TypeConversionException;
/**
 *
 * @author ang_2
 */
public class DateConverter extends StrutsTypeConverter {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");

   
    @Override
    public Date convertFromString(Map map, String[] values, Class type)throws TypeConversionException{
        Date d = null;
        if (values.length > 0 && values[0] != null && values[0].trim().length() > 0) {
            try {
                d = sdf.parse(values[0]);
            } catch (ParseException e) {
                try {
                    d = sdf2.parse(values[0]);
                } catch (ParseException ex) {
                   throw new TypeConversionException("Invalid format...");
                }
            }
        }
        return d;
    }

    @Override
    public String convertToString(Map map, Object o) {
        if (o instanceof Date) {
            return sdf.format((Date) o);
        }
        return "";
    }

}
