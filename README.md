# HUTMOVIE 

### Mobile games development library for android. Android Studio

![](https://img.shields.io/github/stars/pandao/editor.md.svg) ![](https://img.shields.io/github/forks/pandao/editor.md.svg)

## Connection

#### Project:app

```javascript
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
```  

#### Module:app

  ```javascript
  
  	dependencies {
	        implementation 'com.github.Hutsalod:HutMovie:0.0.1'
		}
```  

## Description of library functions

Methods  | Description
------------- | -------------
Show();  | Animation of appearance
Hide();  | The attenuation animation
goLeft();  | Move the object to the left
goRight();  | Move the object to the right
goUp();  | Move the object to the up
goDown();  | Move the object to the down
hitCheck();  | Pushing an object between objects


## Example code

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

## Example Game
![](https://github.com/Hutsalod/HutMovie/blob/master/skrin2png.png)  | ![](https://github.com/Hutsalod/HutMovie/blob/master/screen-1.jpg)
------------- | -------------
 


