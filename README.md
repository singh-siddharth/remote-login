###Remote Login
================

####creates server and client, server can remotely view the client's monitor screen. 


#####Overview:

Remote Login software allows the user to remote control some other remote desktop/laptop at any
other part of world on his desktop/laptop, provided that both of them are connected via Internet
connection.

Server: This side controls the remotely located client. Client at regular intervals sends screenshots to the
server. Server views the client screen and sends commands to the client.

Client: This side sends the screenshots to server at regular intervals and receive commands sent by
server.

#####How to Run:

#####Linux:

#####Server:

1. Download the .zip file. It will have two folders ‘RemoteLoginServer’ and ‘RemoteLoginClient’.
2. Open RemoteLoginServer/dist.
3. Double-Click on clickme.sh.
4. A dialog box appears. Select ‘Run In Terminal’.
5. Enter the listening port.
6. Server is started.


#####Client:

1. Download the .zip file. It will have two folders ‘RemoteLoginServer’ and ‘RemoteLoginClient’.
2. Open RemoteLoginClient/dist.
3. Double-Click on clickme.sh.
4. A dialog box appears. Select ‘Run In Terminal’.
5. Enter the Server IP address.
6. Enter Server’s Port Number.
7. Client desktop now can be controlled by Server.


#####Windows:

#####Server:

1. Open Command Prompt.
2. Navigate to the place where java.exe is present, through Command Prompt.
3. Execute the following command:
java –jar <Path of RemoteLoginServer folder >\dist\RemoteLoginServer.jar

######Client:

1. Open Command Prompt.
2. Navigate to the place where java.exe is present, through Command Prompt.
3. Execute the following command:
java –jar <Path of RemoteLoginClient folder >\dist\RemoteLoginClient.jar
