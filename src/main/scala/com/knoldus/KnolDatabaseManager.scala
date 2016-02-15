package com.knoldus

import java.sql.{ResultSet, PreparedStatement, DriverManager, Connection}

import sun.rmi.runtime.Log.LoggerLogFactory
import org.slf4j.LoggerFactory
/**
  * Created by knoldus on 12/2/16.
  */
object KnolDatabaseManager {

  def connectDatabase():Connection={
    val driver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://localhost/subject_allocation"
    val username = "root"
    val password = "knoldus"
    try {
      Class.forName(driver)
      val connection = DriverManager.getConnection(url, username, password)
      connection
    }
    finally {}
  }

  def search(table:String,field:String,sItem:String):ResultSet={
    val logger=LoggerLogFactory.getLogger(this.getClass())
    logger.
    var querry:String="select * from "+table
    val connection=connectDatabase()
    val statement = connection.createStatement()
    if(field.nonEmpty  && sItem.nonEmpty){
      querry += " where "+field+"='"+sItem+"'"
    }
    val resultSet = statement.executeQuery(querry)
    //connection.close()
    resultSet
  }

  def delete(table:String,field:String,sItem:String):Int={
    val connection=connectDatabase()
    val preparedStatement=connection.prepareStatement("delete from "+table +" where "+field+"='"+sItem+"'")
    val flag=preparedStatement.executeUpdate()
    //connection.close()
    flag
  }

  def add(table:String,listOfValue:List[String]):Int={
    val values=listOfValue.mkString("','  ")
    val connection=connectDatabase()
    val preparedStatement=connection.prepareStatement("insert into "+table+" values('"+values+"')")
    val flag=preparedStatement.executeUpdate()
    //connection.close()
    flag
  }

  def modify(table:String,field:String,newValue:String,idValue:String):Int={
    val connection=connectDatabase()
    val preparedStatement=connection.prepareStatement("update "+table +" set "+field+"='"+newValue+"' where id='"+idValue+"'")
    val flag=preparedStatement.executeUpdate()
    //connection.close()
    flag
  }

}
