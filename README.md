<p align="center">
  <img width="400" height="172" src="https://github.com/Hutsalod/HutMovie/blob/master/fon.png">
</p>

# HUTMOVIE 

### Mobile games development library for android. Android Studio

![](https://img.shields.io/badge/version-0.5-blue) ![](https://img.shields.io/badge/lib-developer-grean)


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
	        implementation 'com.github.Hutsalod:HutMovie:0.5'
		}
		
```  


# Description of library functions

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



# Example code
### activity_main.xml
  ```javascript
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/grass">
    
    <ImageView android:id="@+id/Person1"
        android:layout_width="50dp"
        android:layout_height="50dp"
        app:srcCompat="@drawable/sprite" />
	
    <ImageView android:id="@+id/Person2"
        android:layout_width="50dp"
        android:layout_height="50dp"
        app:srcCompat="@drawable/sprite2" />
	
</FrameLayout>
``` 

### MainActivity.java
  ```javascript
  
public class MainActivity extends AppCompatActivity {

    private HutMovie Game = new HutMovie();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); 

        final ImageView person1 = findViewById(R.id.Person1);
        final ImageView person2 = findViewById(R.id.Person2);

        Game.setGame(new HutMovie.play() {
        @Override
        public void run() {
                Game.goRight(person1, 3); //Move the Person1 to the right
                Game.goDown(person1, 2); //Move the Person1 to the down
                Game.move(person2, 2, 3); //Move the Person2 edges by X and Y
        }
        });
	
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

