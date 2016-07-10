package gh25.raul.raulghweek3.restApi.model;

/**
 * Created by Raul on 09/07/2016.
 */
public class ServerResponse {

    private String id_usuario_instagram;
    private String token;

    public ServerResponse(String id_dispositivo, String id_usuario_instagram, String token) {
        this.id_usuario_instagram = id_usuario_instagram;
        this.token = token;
    }

    public ServerResponse() {
    }


    public String getId_usuario_instagram() {
        return id_usuario_instagram;
    }

    public void setId_usuario_instagram(String id_usuario_instagram) {
        this.id_usuario_instagram = id_usuario_instagram;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
