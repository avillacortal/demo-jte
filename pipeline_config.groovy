pipeline_template   = "default"

libraries {
    maven {
        pomDirectory="demo-jte"
        isPublishable=true
    }
    
    sonarqube{
       //cli_parameters = [" -Dproject.settings=demo-jte/sonar-project.properties"]
    }
    
    oc{
        url                 = 'https://api.ocptest.gp.inet:6443'
        tiller_credential   = 'openshift'

        template            =  "jboss-eap71-openshift:1.2"
        mountPath           =  "/var/opt/teradata/daas-log4j/demo-jte/"
        //tiller_namespace  = "daas"
        app                 ="demo-jte"
        archiveWar     ="demo-jte/target/demo-jte.war"

    }
    
    notification{
        destination = 'anthony0950cvl2@gmail.com'
    }
}

application_environments {

  dev{


    version     = "0.0.2-SNAPSHOT"
    //openshift_url       = 'https://api.ocptest.gp.inet:6443'
    //tiller_credential   = 'openshift'  
    tiller_namespace      = "daas-dev"
    chart_values_file    = "openshift/"



  }

  test{
    version    = "0.0.2"
    //openshift_url       = 'https://api.ocptest.gp.inet:6443'
    //tiller_credential   = 'openshift'
    tiller_namespace      = "daas-qa"
    chart_values_file     = "openshift/"  
  }

  prod{
    version    = "0.0.2"
  }
  
}
