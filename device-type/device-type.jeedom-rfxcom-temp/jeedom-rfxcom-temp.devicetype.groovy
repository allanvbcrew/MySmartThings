/**
 *  Jeedom RFXCom Temp
 *
 *  Copyright 2015 Allan Sebastian
 *
 *  Poll RFXCom devices that are connected to a Raspberry Pi running Jeedom
 *
 */

preferences {
	input("ip_jeedom", "text", title: "192.168.x.x", description: "Your jeedom install IP address")
	input("api_key", "text", title: "Jeedom API key", description: "Your Jeedom API key for accessing the HTTP API")
}

// for the UI
metadata {
	definition (name: "Jeedom RFXCom Temp", namespace: "smartthings-users", author: "dianoga7@3dgo.net") {
		capability "Polling"
		capability "Relative Humidity Measurement"
		capability "Thermostat"
		capability "Temperature Measurement"
		capability "Presence Sensor"
		capability "Sensor"

		command "away"
		command "present"
		command "setPresence"
		command "heatingSetpointUp"
		command "heatingSetpointDown"
		command "coolingSetpointUp"
		command "coolingSetpointDown"
		command "setFahrenheit"
		command "setCelsius"

		attribute "temperatureUnit", "string"
	}


