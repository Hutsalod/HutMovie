# HutMovie
### Mobile games development library for android. Android Studio

![](https://img.shields.io/github/stars/pandao/editor.md.svg) ![](https://img.shields.io/github/forks/pandao/editor.md.svg)


```javascript
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
```  
  ```javascript
  
  	dependencies {
	        implementation 'com.github.Hutsalod:HutMovie:0.0.1'
	}
```  

Methods  | Description
------------- | -------------
Hide();  | Content Cell
Show();  | Content Cell 
goLEFT();  | Content Cell
goRIGHT();  | Content Cell 
goUP();  | Content Cell
goDOWN();  | Content Cell 


## Example

  ```javascript
  
public class MainActivity extends AppCompatActivity {
    private Timer timer = new Timer();
    private Handler handler = new Handler();
    ImageView ImageView,ImageView2;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView = (ImageView)findViewById(R.id.TextView);

        timer.schedule(new TimerTask() {

                @Override
                public void run() {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            HutMovie.goRIGHT(ImageView,5);
                            if(HutMovie.hitCheck(ImageView,ImageView2))
                                Log.d("LOG","FINISH!");
                                
                        }
                    });
                }
            }, 0, 20);
    }
```  
