package com.knoldus

import org.scalatest.FunSuite
/**
  * Created by knoldus on 12/2/16.
  */
class KnolDatabaseManagerTest extends FunSuite{

  test("insert a record to [student]"){
    val result = KnolDatabaseManager.add("student",List("s002","Rahul","rahul.kumar@knoldus.in","123456789"))
    assert(result==1)
  }

  test("insert a record to [subject]"){
    val result = KnolDatabaseManager.add("subject",List("j001","Java Programming"))
    assert(result==1)
  }

  test("insert a record to [allocation]"){
    val result = KnolDatabaseManager.add("allocation",List("a002","s002","j001"))
    assert(result==1)
  }

  test("update a record to[student]"){
    val result = KnolDatabaseManager.modify("student","mob","234567891","s001")
    assert(result==1)
  }

  test("update a record to[subject]"){
    val result = KnolDatabaseManager.modify("subject","name","OOP","j001")
    assert(result==1)
  }

  test("update a record to[allocation]"){
    val result = KnolDatabaseManager.modify("allocation","sub_id","c001","a001")
    assert(result==1)
  }

  test("search a record to [student]"){
    val result=KnolDatabaseManager.search("student","id","s002")
    assert(result==1)
  }

  test("search a record to [subject]"){
    val result=KnolDatabaseManager.search("subject","id","c001")
    assert(result==1)
  }

  test("search a record to [allocation]"){
    val result=KnolDatabaseManager.search("allocation","id","a001")
    assert(result==1)
  }


  test("delete a record to [student]"){
    val result=KnolDatabaseManager.delete("student","id","s001")
    assert(result==1)
  }

  test("delete a record to [subject]"){
    val result=KnolDatabaseManager.delete("subject","id","j001")
    assert(result==1)
  }

  test("delete a record to [allocation]"){
    val result=KnolDatabaseManager.delete("allocation","id","a001")
    assert(result==1)
  }


}
