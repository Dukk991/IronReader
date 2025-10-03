package org.example;

import org.robotframework.remoteserver.RemoteServer;

public class ServerLauncherRF {
    public static void main(String[] args) throws Exception {
        RemoteServer.configureLogging();
        RemoteServer server = new RemoteServer(8270);
        server.putLibrary("/MemoryLibrary", new MemoryDataProcess());
        server.start();

        System.out.println("Robot Framework Remote Server running on port 8270");
    }
}