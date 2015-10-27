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
	definition (name: "Jeedom RFXCom Temp", namespace: "MySmartThings", author: "allanvbcrew") {
		capability "Relative Humidity Measurement"
		capability "Temperature Measurement"
		capability "Battery"
	}
	
	simulator {
		// TODO: define status and reply messages here
	}
	
	tiles {
		valueTile("temperature", "device.temperature", canChangeIcon: true, canChangeBackground:true) {
			state("temperature", label: '${currentValue}°', backgroundColors: [
				// Celsius Color Range
				[value: 0, color: "#153591"],
				[value: 7, color: "#1e9cbb"],
				[value: 15, color: "#90d2a7"],
				[value: 23, color: "#44b621"],
				[value: 29, color: "#f1d801"],
				[value: 33, color: "#d04e00"],
				[value: 36, color: "#bc2323"],
			]
			)
		}
		
		valueTile("humidity", "device.humidity", inactiveLabel: false) {
			state "default", label:'${currentValue}%', unit:"Humidity"
		}
		
		valueTile("battery", "device.battery", decoration: "flat", inactiveLabel: false, width: 2, height: 2) {
        		state "battery", label:'${currentValue}% battery', unit:""
    		}
    		
    		main(["temperature", "humidity"])
    		details(["temperature","humidity","battery"])
	}
}

//handle commands
def temperature = new physicalgraph.device.HubAction(
    method: "GET",
    path: "/jeedom/core/api/jeeApi.php",
    headers: [
        HOST: "192.168.0.20"
    ],
    query: [apikey: "xdie3axifu43nk9jqn07", type: "cmd", id: "11"]
)

