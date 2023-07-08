package com.teamgeneral.forcheck;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView tv_city, text_view_condition, textview_temp, long_text, rain_percent, humidity_percent, text_wind;
    private TextInputLayout text_input;
    private TextInputEditText textinput_edittext;
    private ImageView image_view_search, image_icon;
    private RecyclerView rv_weather;
    private ArrayList<RvModel> weatherArraylist;
    private AdaptorR adaptorR;
    private LocationManager locationManager;
    private int PERMISSION_CODE = 1;
    private String cityName;
   // public TextView next_to_forecast;
    private TextView tv_time;
    //
    private AdaptorF adaptorF;
    private ArrayList<RvModel2> ForecastArrayList;
    private RecyclerView rv_weather2;

    //arraylist

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);//to ma
        tv_city = (TextView) findViewById(R.id.tv_city);
        text_view_condition = (TextView) findViewById(R.id.text_view_condition);
        textview_temp = (TextView) findViewById(R.id.textview_temp);
        long_text = (TextView) findViewById(R.id.long_text);
        rain_percent = (TextView) findViewById(R.id.rain_percent);
        humidity_percent = (TextView) findViewById(R.id.humidity_percent);
        text_wind = (TextView) findViewById(R.id.text_wind);
        text_input = (TextInputLayout) findViewById(R.id.text_input);
        textinput_edittext = (TextInputEditText) findViewById(R.id.textinput_edittext);
        image_view_search = (ImageView) findViewById(R.id.image_view_search);
        image_icon = (ImageView) findViewById(R.id.image_icon);
        rv_weather = (RecyclerView) findViewById(R.id.rv_weather);

        tv_time=(TextView)findViewById(R.id.tv_time);
        rv_weather2=(RecyclerView)findViewById(R.id.rv_weather2);


        //arraylist
        weatherArraylist = new ArrayList<>();
        adaptorR = new AdaptorR(this, weatherArraylist);
        rv_weather.setAdapter(adaptorR);
        //forecast 7 days
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rv_weather2.setLayoutManager(linearLayoutManager);
        ForecastArrayList=new ArrayList<>();

//        ForecastArrayList.add(new RvModel2("22","12","image","23","timessdfj"));
//        ForecastArrayList.add(new RvModel2("22","12","image","23","timessdfj"));
//        ForecastArrayList.add(new RvModel2("22","12","image","23","timessdfj"));
//        ForecastArrayList.add(new RvModel2("22","12","image","23","timessdfj"));
        adaptorF=new AdaptorF(this,ForecastArrayList);
        rv_weather2.setAdapter(adaptorF);



        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);//initialize
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, PERMISSION_CODE);
        } else {
            getLocation();
        }
        textinput_edittext.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                text_input.setHintEnabled(false);
                return false;
            }
        });
        //delete





        image_view_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city = textinput_edittext.getText().toString();
                if (city.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a city name", Toast.LENGTH_SHORT).show();
                } else {
                    getWeatherInfo(city);
                    getWeatherInfoo(city);
                }
            }
        });
    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            LocationListener locationListener = new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    cityName = getCityName(latitude, longitude);
                    getWeatherInfo(cityName);
                    getWeatherInfoo(cityName);
                    locationManager.removeUpdates(this);
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {
                }

                @Override
                public void onProviderEnabled(String provider) {
                }

                @Override
                public void onProviderDisabled(String provider) {
                }
            };
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
            Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (lastKnownLocation != null) {
                double latitude = lastKnownLocation.getLatitude();
                double longitude = lastKnownLocation.getLongitude();
                cityName = getCityName(latitude, longitude);
                getWeatherInfo(cityName);
                getWeatherInfoo(cityName);

            } else {
                Toast.makeText(this, "Failed to get location.", Toast.LENGTH_SHORT).show();
            }
        }
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
                getLocation();
            } else {
                Toast.makeText(this, "Please provide location permission", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    private String getCityName(double latitude, double longitude) {
        String cityName = "Not found";
        Geocoder geocoder = new Geocoder(getBaseContext(), Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 10);
            for (Address address : addresses) {
                if (address != null) {
                    String city = address.getLocality();
                    if (city != null && !city.equals("")) {
                        cityName = city;
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cityName;
    }

    private void getWeatherInfo(String cityName) {
        String url = "http://api.weatherapi.com/v1/forecast.json?key=2741fd30446a4739a05133333230307&q=" + cityName + "&days=1&aqi=no&alerts=no";
        tv_city.setText(cityName);
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                weatherArraylist.clear();
                //added
                ForecastArrayList.clear();
                try {
                    String temperature = response.getJSONObject("current").getString("temp_c");
                    textview_temp.setText(temperature + "℃");
                    //int isDay = response.getJSONObject("current").getInt("is_day");
                    String condition = response.getJSONObject("current").getJSONObject("condition").getString("text");
                    String conditionIcon = response.getJSONObject("current").getJSONObject("condition").getString("icon");
                    Picasso.get().load("http:".concat(conditionIcon)).into(image_icon);

                    text_view_condition.setText(condition);
                    String humid = response.getJSONObject("current").getString("humidity");
                    humidity_percent.setText(humid);
                    String winds=response.getJSONObject("current").getString("wind_mph");
                    text_wind.setText(winds);
                    //int rainn = response.getJSONObject("current").getInt("daily_will_it_rain");
                    String latt=response.getJSONObject("location").getString("lat");
                    String longg=response.getJSONObject("location").getString("lon");
                    long_text.setText("H: "+ latt+"L: "+longg);
                    String rain=response.getJSONObject("current").getString("cloud");
                    rain_percent.setText(rain);
                    String times=response.getJSONObject("location").getString("localtime");
                    tv_time.setText(times);


//                    if (isDay == 1) {
//                        //morning
//                        Picasso.get().load("https://images.hdqwalls.com/download/dreamscape-blue-morning-4k-fp-1080x1920.jpg").into(image_view1);
//                    } else {
//                        Picasso.get().load("https://th.bing.com/th/id/OIP.GvFf5gAjQpuIRZjnI6I9VwHaNK?pid=ImgDet&w=1080&h=1920&rs=1").into(image_view1);
//                    }
                    JSONObject forecastObj = response.getJSONObject("forecast");
                    JSONObject forecastO = forecastObj.getJSONArray("forecastday").getJSONObject(0);
                    JSONArray hourArray = forecastO.getJSONArray("hour");

                    //forcast object
//                    JSONObject forecast1=forecastObj.getJSONArray("forecastday").getJSONObject(0);
//                    JSONArray forecastArray=forecast1.getJSONArray("day");
                    //JSONArray tempArray = forecastObj.getJSONArray("day");



                    for (int i = 0; i < hourArray.length(); i++) {
                        JSONObject hourObj = hourArray.getJSONObject(i);
                        String time = hourObj.getString("time");
                        String temper = hourObj.getString("temp_c");
                        String img = hourObj.getJSONObject("condition").getString("icon");
                        String wind = hourObj.getString("wind_kph");

                        weatherArraylist.add(new RvModel(time,temper,img,wind));
                        //ForecastArrayList.add(new RvModel2(time,temper,img,wind));
                    }
                    adaptorR.notifyDataSetChanged();
                    //adapotr2
                    //adaptorF.notifyDataSetChanged();
                    //forecast for loop
                    for(int i=0;i<=6;i++){

//                        JSONObject dayObj= tempArray.getJSONObject(i);
//                        String day=dayObj.getString("time");
////                        String temp=dayObj.getJSONObject("day").getString("temp_c");
////                        String temp1=dayObj.getJSONObject("hour").getString("temp_f");
////                        String imgc=dayObj.getJSONObject("condition").getString("icon");
////                        String status=dayObj.getJSONObject("condition").getString("text");
//                        String temp = dayObj.getJSONObject("day").getString("avgtemp_c");
//                        String temp1 = dayObj.getJSONObject("day").getString("avgtemp_f");
//                        String imgc = dayObj.getJSONObject("day").getJSONObject("condition").getString("icon");
//                        String status = dayObj.getJSONObject("day").getJSONObject("condition").getString("text");



                        //ForecastArrayList.add(new RvModel2(day,temp,imgc,temp1,status));

                    }
                    //adaptorF.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Please enter a valid city name", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
    private void getWeatherInfoo(String cityName) {
        String url = "http://api.weatherapi.com/v1/forecast.json?key=2741fd30446a4739a05133333230307&q=" + cityName + "&days=7&aqi=no&alerts=no";
        tv_city.setText(cityName);
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                ForecastArrayList.clear();
                try {
                    JSONObject forecastObj = response.getJSONObject("forecast");
                    JSONArray forecastdayArray = forecastObj.getJSONArray("forecastday");
                    for (int i = 0; i < forecastdayArray.length(); i++) {
                        JSONObject forecastdayObj = forecastdayArray.getJSONObject(i);
                        String date = forecastdayObj.getString("date");
                        JSONObject dayObj = forecastdayObj.getJSONObject("day");
                        String maxTemp = dayObj.getString("maxtemp_c");
                        String minTemp = dayObj.getString("mintemp_c");
                        String img = dayObj.getJSONObject("condition").getString("icon");
                        String status=dayObj.getJSONObject("condition").get("text").toString();
                        String wind = dayObj.getString("maxwind_kph");
                        ForecastArrayList.add(new RvModel2(date, img,maxTemp, status,wind));
                    }

                    adaptorF.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Please enter a valid city name", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }


}






