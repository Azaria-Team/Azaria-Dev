pluginManagement{
 repositories{
  gradlePluginPortal()
  maven("https://raw.githubusercontent.com/GlennFolker/EntityAnnoMaven/main")
 }

 plugins{
  val kotlinVersion: String by settings
  val entVersion: String by settings
  id("com.github.GlennFolker.EntityAnno") version(entVersion)
  id("org.jetbrains.kotlin.jvm") version(kotlinVersion)
  id("org.jetbrains.kotlin.kapt") version(kotlinVersion)
 }
}

if(JavaVersion.current().ordinal < JavaVersion.VERSION_17.ordinal){
 throw IllegalStateException("JDK 17 is a required minimum version. Yours: ${System.getProperty("java.version")}")
}

val modName: String by settings
rootProject.name = modName