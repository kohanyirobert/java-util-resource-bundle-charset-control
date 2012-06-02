# java-util-resource-bundle-charset-control

[Resource bundle control][] which uses a specific [charset][] to load [resource
bundles][] backed by property files.

## License
Released under the permissive [MIT License][].

## Author
[Kohányi Róbert][].

## Download
Add the library as a dependency in your project's *pom.xml* like this.

```xml
<dependency>
  <groupId>com.github.kohanyirobert</groupId>
  <artifactId>java-util-resource-bundle-charset-control</artifactId>
  <version>...</version>
</dependency>
```

Releases and snapshots are deployed to [Sonatype's][] [OSS repository][] (and
synced to the [Central Maven Repository][] from there). To download JARs from
Sonatype's repository include the following repository tag inside your Maven
installation's *settings.xml* or your project's *pom.xml*.

```xml
<repository>
  <id>sonatype-oss</id>
  <url>https://oss.sonatype.org/content/groups/public</url>
</repository>
```

## Build
As the project is managed with [Maven][] you simply clone it and issue *mvn
install* or *mvn package* inside the clone's directory.

```
git clone git://github.com/kohanyirobert/java-util-resource-bundle-charset-control.git
cd java-util-resource-bundle-charset-control/
mvn package
# and/or
mvn install
```

## Usage
```java
String baseName = ...
Charset charset = ...
Control = new CharsetControl(charset);
ResourceBundle bundle = ResourceBundle.getBundle(baseName, control);
```

## Note
If you plan to reload the *same* resource bundle using different charsets then
you should clear the resource bundle cache before subsequent reloads.

```java
ResourceBundle.clearCache();
```

[Central Maven Repository]: http://search.maven.org
[Kohányi Róbert]: http://kohanyirobert.github.com
[MIT License]: https://raw.github.com/kohanyirobert/java-util-resource-bundle-charset-control/master/LICENSE.txt
[Maven]: http://maven.apache.org
[OSS repository]: https://oss.sonatype.org
[Resource bundle control]: http://docs.oracle.com/javase/6/docs/api/java/util/ResourceBundle.Control.html
[Sonatype's]: http://sonatype.com
[charset]: http://docs.oracle.com/javase/6/docs/api/java/nio/charset/Charset.html
[resource bundles]: http://docs.oracle.com/javase/6/docs/api/java/util/ResourceBundle.html
