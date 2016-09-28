Connecting to Spark:

C:\...\h2-2016-05-26\bin>java -jar h2-1.4.192.jar -web -webAllowOthers -tcp -tcpAllowOthers -browser
Web Console server running at http://192.168.10.1:8082 (others can connect)
TCP server running at tcp://192.168.10.1:9092 (others can connect)

then

C:\development\software\spark-2.0.0-bin-hadoop2.7\bin>spark-shell.cmd
--driver-class-path C:/.../.m2/repository/com/h2database/h2/1.4.192/h2-1.4.192.jar
--conf spark.sql.warehouse.dir=file:///C:/Temp/spark-warehouse

Using Spark's default log4j profile: org/apache/spark/log4j-defaults.properties
Setting default log level to "WARN".
To adjust logging level use sc.setLogLevel(newLevel).

val url="jdbc:h2:tcp://localhost/~/worldbank-db"
val properties = new java.util.Properties
properties.setProperty("user","sa")
properties.setProperty("password", "password")
val sqlContext = new org.apache.spark.sql.SQLContext(sc)

val dataPoint = sqlContext.read.jdbc(url, "DATA_POINT", properties)
val indicator = sqlContext.read.jdbc(url, "INDICATOR", properties)
val country = sqlContext.read.jdbc(url, "COUNTRY", properties)
val catalogSource = sqlContext.read.jdbc(url, "CATALOG_SOURCE", properties)
val incomeLevel = sqlContext.read.jdbc(url, "INCOME_LEVEL", properties)

dataPoint.show()
indicator.show()
country.show()
catalogSource.show()
incomeLevel.show()