package gh25.raul.raulghweek3.restApi;


import gh25.raul.raulghweek3.restApi.model.MascotaResponse;
import gh25.raul.raulghweek3.restApi.model.ServerResponse;
import gh25.raul.raulghweek3.restApi.model.UsuarioResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Raul on 25/06/2016.
 */
public interface EndpointsApi {


    //@GET(ConstantsRestApi.URL_GET_USER_DATA_BY_ID)
    String urlmedia = "users/{id}/media/recent/?access_token=" + ConstantsRestApi.ACCESS_TOKEN;
    @GET(urlmedia)
    Call<MascotaResponse> getRecentMedia(@Path("id") String userid);


    //@GET(ConstantsRestApi.URL_GET_USER_INF_BY_NAME)
    String urlusuario = "users/search";
    @GET(urlusuario)
    Call<UsuarioResponse> getUserID(
            @Query("q") String userid,
            @Query("access_token") String tokem
    );


    @FormUrlEncoded
    @POST(ConstantsRestApi.SERVER_TOKEN_KEY)
    Call<ServerResponse> registrarUsuario(@Field("token") String token, @Field("id_usuario_instagram") String id_usuario_instagram );
    // token es el id del dispositivo
}

