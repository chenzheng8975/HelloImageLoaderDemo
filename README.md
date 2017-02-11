# HelloImageLoaderDemo
###Android网络图片加载三级缓存
内存缓存, 优先加载, 速度最快
本地缓存, 次优先加载, 速度快
网络缓存, 不优先加载, 速度慢, 浪费流量

### Screenshot

<img src="/screenshot/1.gif" alt="screenshot" title="home" width="270" height="486" />

### Dependency

#### Gradle

```
  dependencies {
  	        compile 'com.github.chenzheng8975:HelloImageLoaderDemo:1.0.0'
  	}
```

#### Maven
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
