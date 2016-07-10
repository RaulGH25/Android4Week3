package gh25.raul.raulghweek3;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import gh25.raul.raulghweek3.restApi.ConstantsRestApi;
import gh25.raul.raulghweek3.restApi.EndpointsApi;
import gh25.raul.raulghweek3.restApi.adapter.RestApiAdapter;
import gh25.raul.raulghweek3.restApi.model.ServerResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Raul on 09/07/2016.
 */
public class NotificationIDTokenService extends FirebaseInstanceIdService {

    private static final String TAG = "MyFirebaseIIDService";

    @Override
    public void onTokenRefresh() {
        //super.onTokenRefresh();
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        // enviarTokenRegistro(refreshedToken, ConstantsRestApi.USER_ID); ÂRA QUE NO SE REPITA
    }


    private void enviarTokenRegistro(String token, String id_usuario_instagram){

        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndpointsApi endpoints = restApiAdapter.establecerConexionRestApiHeroku();
        Call<ServerResponse> serverResponseCall = endpoints.registrarUsuario(token, id_usuario_instagram);

        serverResponseCall.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                ServerResponse serverResponse = response.body();
                Log.i(" - ID dispositivo -", serverResponse.getId_dispositivo());
                Log.i(" - ID usuario inst -", serverResponse.getId_usuario_instagram());
                Log.i(" - token disp -", serverResponse.getToken());
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                Log.i(" ---- Error ---", "Error");
            }
        });


    }

}
