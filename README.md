
# fuzzy-potato  
Create a master-detail application that contains at least one dependency. This application should display a list of items obtained from a iTunes Search API and show a detailed view for each item.  
  
# Techology used  
- Kotlin  
- Android Navigation Architecture Component  
- Rx (RxAndroid, RxKotlin)  
- Android Room Database  
- Retrofit  
- [Koin](https://insert-koin.io) (Dependency injection)  
- [Coil](https://coil-kt.github.io/coil/) (Image loader)
  
# Design Pattern  
- MVVM   
- Leveraged Koin support for ModelView  
  
# Modules  
- app (Android Main Application)  
- models   
- network (Handles API Request)  
- room (Handles local caching)  
  
# How it works?  
- In [MainActivity](/app/src/main/java/com/ceosilvajr/starwars/MainActivity.kt) there is a   
function called `initializeMovieData()` calls api request to remote server and saves the data to   
local database.  

```kotlin 
    private fun initializeMovieData() {
        onlineMovieViewModel.onlineMovieLiveData.observe(this, Observer {
            localMovieViewModel.insertMovies(it)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe()
                    .addTo(compositeDisposable)
        })
        onlineMovieViewModel.requestNewMovies()
    }
```  
 
- In [HomeFragment](/app/src/main/java/com/ceosilvajr/starwars/fragments/HomeFragment.kt) check   
the function called `observerLocalMovies()` this will emit the list of data from local database.  

```kotlin 
    private fun observerLocalMovies() {
        localMovieViewModel.observeLocalMovie(activity!!) {
            movieListAdapter.updateList(it as ArrayList<Movie>)
        }
    }
```  
  
# Improvements can be done  
- Implement pull to refresh [issue #12](https://github.com/ceosilvajr/fuzzy-potato/issues/12)
- Network error handling [issue #4](https://github.com/ceosilvajr/fuzzy-potato/issues/11])
- Animate fragment transition [issue #10](https://github.com/ceosilvajr/fuzzy-potato/issues/10)
- Improve gradle dependencies [issue #13](https://github.com/ceosilvajr/fuzzy-potato/issues/13)

# Demo  
- [Workin APK](/art/app.apk)
![Animated Gif](/art/demo.gif)  

  