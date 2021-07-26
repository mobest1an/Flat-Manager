package client;

public class ConnectionStatus {

    private static boolean connectionStatus;

    public static boolean isConnected() {
        return connectionStatus;
    }

    public static void setConnectionStatus(boolean connectionStatus) {
        ConnectionStatus.connectionStatus = connectionStatus;
    }
}
