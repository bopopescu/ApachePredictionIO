# ApachePredictionIO
Documentation regarding Installation of apache-prediction-io and Running the application.

1. Step wise installation of apache-prediction-io.<br />
  a. Download apache-prediction-io source-code here http://predictionio.incubator.apache.org/install.<br />
  b. Download Ecommerce Recommendaton Template from here http://predictionio.incubator.apache.org/gallery/template-gallery/.<br />
  c. Follow http://predictionio.incubator.apache.org/install/install-sourcecode/ to install apache-prediction-io from source code.<br />


2. Setting up environments.<br />
  a. First install mysql(or)postgresql(or)Hbase for creating database.I have chosen mysql.<br />
  b. Next install spark (elasticsearch and Hbase could be installed according to your needs).<br />
  c. Create a database by name pio in mysql with admin username and password as pio and pio respectively.(Can set to anything as      u wish.)<br />
  d. Next move to the PredictionIo folder >> conf >> open pio-env.sh file and do as below :<br />
      1. Move to Storage repositories and replace as below:<br />
        # Storage Repositories
           # Default is to use PostgreSQL
              PIO_STORAGE_REPOSITORIES_METADATA_NAME=pio_meta
              PIO_STORAGE_REPOSITORIES_METADATA_SOURCE=MYSQL

              PIO_STORAGE_REPOSITORIES_EVENTDATA_NAME=pio_event
              PIO_STORAGE_REPOSITORIES_EVENTDATA_SOURCE=MYSQL

              PIO_STORAGE_REPOSITORIES_MODELDATA_NAME=pio_model
              PIO_STORAGE_REPOSITORIES_MODELDATA_SOURCE=MYSQL
              
      2. Move to MySql Example and replace as below:<br />
          # MySQL Example
              PIO_STORAGE_SOURCES_MYSQL_TYPE=jdbc
              PIO_STORAGE_SOURCES_MYSQL_URL=jdbc:mysql://127.0.0.1/pio<databasename>
              PIO_STORAGE_SOURCES_MYSQL_USERNAME=pio<mysql pio database username>
              PIO_STORAGE_SOURCES_MYSQL_PASSWORD=pio<mysql pio database password>
              
          # Username and Password above are same as u have given to the database <pio> in mysql. 

3. Next Follow http://predictionio.incubator.apache.org/templates/ecommercerecommendation/quickstart/ to get the 
   apache-prediction-io running and started so that we can deploy our application.
          
4. Once the eventserver is running open the ECOM Project in eclipse and run it on the server .

5. Below is the snapshot of the application :<br />
   ![Alt text](/AppFront.jpg?raw=true "Optional Title")
