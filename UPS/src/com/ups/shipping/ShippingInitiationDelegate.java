package com.ups.shipping;

import javax.json.*;
import javax.ws.rs.core.*;
import javax.jws.WebService;


@WebService (targetNamespace="http://shipping.ups.com/", serviceName="ShippingInitiationService", portName="ShippingInitiationPort", wsdlLocation="WEB-INF/wsdl/ShippingInitiationService.wsdl")
public class ShippingInitiationDelegate{

    com.ups.shipping.ShippingInitiation _shippingInitiation = null;

    public Response ping () {
        return _shippingInitiation.ping();
    }

    public JsonObject initiateShipping (JsonObject incomingJson) {
        return _shippingInitiation.initiateShipping(incomingJson);
    }

    public ShippingInitiationDelegate() {
        _shippingInitiation = new com.ups.shipping.ShippingInitiation(); }

}