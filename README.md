# Orbot Reqeust V3 Onion Service Intent 

Barebones application that shows how an application can ask Orbot to create a V3 Onion Service.

The requesting application sends an `Intent` with the port of the service running on the device,
the port clients will use to access the service on the tor network, and fianlly a name for 
the service that users of Orbot will see in the app.

Launching the `Intent` will open Orbot, when Orbot generates an Onion Service, it'll finish 
and the requesting Activity can get the v3 onion hostname for the requested service. 

