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

Methods   |  Description
------------- | -------------
goLeft();  | Move the object to the left
goRight();  | Move the object to the right
goUp();  | Move the object to the up
goDown();  | Move the object to the down

Methods   |  Description
------------- | -------------
hitCheck();  | Pushing an object between objects


## Example code

  ```javascript
  
public class MainActivity extends AppCompatActivity {
    private Timer timer = new Timer();
    private Handler handler = new Handler();

    ImageView Person1,Person2;

    HutMovie hutMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hutMovie = new HutMovie();

        Person1 = (ImageView)findViewById(R.id.Person1);
        Person2 = (ImageView)findViewById(R.id.Person2);

        timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            hutMovie.goRight(Person1,3);
                            hutMovie.goRight(Person2,2);
                            hutMovie.goDown(Person1,2);
                            hutMovie.goDown(Person2,3);
                        }
                    });
                }
            }, 0, 20);
    }
```  

## Example Game
![](https://github.com/Hutsalod/HutMovie/blob/master/skrin2png.png)  | ![](https://github.com/Hutsalod/HutMovie/blob/master/screen-1.jpg)
------------- | -------------
 

## How to build

Retrolambda needs java8 to be installed on your system
```
export ANDROID_HOME=/path/to/android/sdk

git clone https://github.com/Hutsalod/Rocket.Chat.Java.Android
cd Rocket.Chat.Android

echo "sdk.dir="$ANDROID_HOME > local.properties

./gradlew assembleDebug
```


## Bug report & Feature request

Please report via [GitHub issue](https://github.com/Hutsalod/Rocket.Chat.Java.Android/issues) :)

