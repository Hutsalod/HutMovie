<p align="center">
  <img width="400" height="172" src="https://github.com/Hutsalod/HutMovie/blob/master/fon.png">
</p>

# HUTMOVIE 

### Mobile games development library for android. Android Studio

![](https://img.shields.io/badge/version-0.4-blue) ![](https://img.shields.io/badge/lib-developer-grean)

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
	        implementation 'com.github.Hutsalod:HutMovie:0.4'
		}
		
```  

## Description of library functions

Methods  | Description
------------- | -------------
show();  | Animation of appearance
hide();  | The attenuation animation

Methods   |  Description
------------- | -------------
goLeft();  | Move the object to the left
goRight();  | Move the object to the right
goUp();  | Move the object to the up
goDown();  | Move the object to the down
move();  | Moved edges by X and Y
position();  | Move the object to the X and Y

Methods   |  Description
------------- | -------------
isCheck();  | Pushing an object between objects
isRoom();  | The object is not in the room


## Example code

  ```javascript
  
public class MainActivity extends AppCompatActivity {

    private Handler play = new Handler();

    private ImageView Person1, Person2;

    private HutMovie hutMovie = new HutMovie();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); 

        Person1 = findViewById(R.id.Person1);
        Person2 = findViewById(R.id.Person2);

 
		play.post(new Runnable() {
		@Override
			public void run() {
			hutMovie.goRight(Person1, 3);
			hutMovie.goRight(Person2, 2);
			hutMovie.goDown(Person1, 2);
			hutMovie.goDown(Person2, 3);
			    
                	play.post(this);
            	}
        	},20);  
	    
    }
```  

### Running app
  <img width="150" height="250" src="https://github.com/Hutsalod/HutMovie/blob/master/ezgif.com-video-to-gif-2.gif">
  
## Example Game
![](https://github.com/Hutsalod/HutMovie/blob/master/skrin2png.png)  | ![](https://github.com/Hutsalod/HutMovie/blob/master/screen-1.jpg)
------------- | -------------
 

## How to build

Retrolambda needs java8 to be installed on your system
```
export ANDROID_HOME=/path/to/android/sdk

git clone https://github.com/Hutsalod/HutMovie
cd HutMovie

echo "sdk.dir="$ANDROID_HOME > local.properties

./gradlew assembleDebug
```


## Bug report & Feature request

Please report via [GitHub issue](https://github.com/Hutsalod/HutMovie/issues) :)

