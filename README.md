⠀
⠀⠀
⠀

<p align="center">
  <img width="400"  src="https://github.com/Hutsalod/HutMovie/blob/master/fon.png">
</p>

⠀
⠀
# HUTMOVIE ✌️🚀

### Mobile games development library for android. Android Studio
[![GitHub release (latest by date)](https://img.shields.io/github/v/release/Hutsalod/HutMovie?style=for-the-badge)](https://github.com/Hutsalod/HutMovie/releases/latest)
![GitHub](https://img.shields.io/github/license/Hutsalod/HutMovie?style=for-the-badge)
<a href="https://ko-fi.com/hutsalod" title="Donate to this project using Buy Me A Coffee"><img src="https://img.shields.io/badge/Donate-buy%20me%20a%20coffee-blue.svg?style=for-the-badge" alt="Buy Me A Coffee donate button" /></a>

⠀
## 🛠 CONNECTION
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
	        implementation 'com.github.Hutsalod:HutMovie:0.8'
		}
		
``` 

⠀
## 📃 DESCRIPTION OF LIBRARY FUNCTIONS

Methods  | Description
------------- | -------------
show();  | Animation of appearance
hide();  | The attenuation animation

Methods   |  Description
------------- | -------------
left();  | Move the object to the left
right();  | Move the object to the right
up();  | Move the object to the up
dowm();  | Move the object to the down
move();  | Move edges by X and Y
position();  | Move the object to the X and Y
rotation();  | objecct rotation
collision();  | Pushing an object between objects
jump();  | High jump
follow();  | Movement to the object

Methods   |  Description
------------- | -------------
isRoom();  | The object is not in the room
repeat();  | Repeat the animation

⠀
## 🎲 EXAMPLE CODE
#### activity_main.xml 🎨
  ```javascript
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

#### MainActivity.java 🛠
  ```javascript
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); 
	
	    HutMovie person1 = new HutMovie(findViewById(R.id.Person1));
        HutMovie person2 = new HutMovie(findViewById(R.id.Person2));

        person1.right(200)
               .repeat(true)
               .onRun();

        person2.move(200,300)
               .repeat(true)
               .onRun();
		
    }
    
}
```  

#### Running app 📲
  <img width="170" height="300" src="https://github.com/Hutsalod/HutMovie/blob/master/ezgif.com-video-to-gif-2.gif">

⠀
## 🎲 EXAMPLE CODE II COLLISION
#### activity_main.xml 🎨
  ```javascript
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
        android:layout_gravity="right"
        app:srcCompat="@drawable/sprite2" />
	
</FrameLayout>
``` 

#### MainActivity.java 🛠
  ```javascript
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); 
	
        final HutMovie person1 = new HutMovie(findViewById(R.id.Person1));
        final HutMovie person2 = new HutMovie(findViewById(R.id.Person2));

        person1.move(300,300)
               .repeat(true)
               .onRun();

        person2.move(-300,300)
               .collision(person1)
               .repeat(true)
               .onRun();
		
        person2.setAction(new HutMovie.ActionCollision() {
               public void onActionCollision() {
               Toast.makeText(getApplicationContext(), "WORKING!",Toast.LENGTH_LONG).show();
        }})
	
	}
    
}
```  

#### Running app 📲
  <img width="170" height="300" src="https://github.com/Hutsalod/HutMovie/blob/master/collision.gif">

⠀
## 👏 EXAMPLE GAME
<img height="400" src="https://github.com/Hutsalod/HutMovie/blob/master/screen1.png"><img height="400" src="https://github.com/Hutsalod/HutMovie/blob/master/screen2.png">
 ⠀

## ✍️ How to build

Retrolambda needs java8 to be installed on your system
```
export ANDROID_HOME=/path/to/android/sdk

git clone https://github.com/Hutsalod/HutMovie
cd HutMovie

echo "sdk.dir="$ANDROID_HOME > local.properties

./gradlew assembleDebug
```

 
## 📃 Bug report & Feature request

Please report via [GitHub issue](https://github.com/Hutsalod/HutMovie/issues) :)
<p align="center">
  <img width="250" height="150" src="https://raw.githubusercontent.com/Hutsalod/HutMovie/master/end.gif">
</p>
