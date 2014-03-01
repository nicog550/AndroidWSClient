/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.ws;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class WSA {

    private static final String SOAP_ACTION = "http://10.0.2.2:8080/Practica1/ConnexioHotel";
    private static final String METHOD_NAME = "existeixDisponibilitat";
    private static final String NAMESPACE = "http://webservice/";
    private static final String URL = "http://10.0.2.2:8080/Practica1/ConnexioHotel?wsdl";

    public WSA() {
    }

    public String cercarDisponibilitat(String dataIni, String dataFi, String places) {
        String res = "";
        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
        request.addProperty("dataIni",  dataIni); 
        request.addProperty("dataFi", dataFi);
        request.addProperty("places", places);
        
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);
        HttpTransportSE ht = new HttpTransportSE(URL);
        try {
            ht.call(SOAP_ACTION, envelope);
            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
            res = response.toString();

        } catch (Exception e) {
            e.printStackTrace();
            res = res + e.toString();
        }
        return res;
    }
 }
