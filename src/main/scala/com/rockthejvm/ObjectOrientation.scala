package com.rockthejvm

object ObjectOrientation extends App {

    // class and instance
    class Animal {
        // define fields
        val age: Int = 0
        // define methods
        def eat() = println("I'm eating")
    }
    val anAnimal = new Animal

    // inheritance
    class Dog(val name: String) extends Animal //constructor definition
    val aDog = new Dog("Lassie")

    // constructor arguments are NOT fields: need to put a val before the constructor argument
    aDog.name

    // subtype polymorphism
    val aDeclaredAnimal: Animal = new Dog("Hachi")
    aDeclaredAnimal.eat() // the most derived method will be called at runtime

    // abstract classes
    abstract class WalkingAnimal {
        val hasLegs = true // by default, fields are public, can restrict by adding private or protected
        private val hasFur = true // this field is only visible in this class
        def walk(): Unit
    }

    // 'interface' = ultimate abstract type
    trait Carnivore {
        def eat(animal: Animal): Unit
    }

    trait Philosopher {
        def ?!(thought: String): Unit // valid method name
    }

    // single class inheritance, but multiple trait inheritance
    class Crocodile extends Animal with Carnivore with Philosopher{
      override def eat(animal: Animal): Unit = println("I'm a crocodile and I'm eating you, animal!")
      override def eat(): Unit = super.eat()
      override def ?!(thought: String): Unit = println(s"I was thinking: $thought")
    }

    val aCroc = new Crocodile
    aCroc.eat(aDog)
    aCroc eat aDog // infix notation = object method argument, only available for methods with ONE argument
    aCroc ?! "What if I could cry?"

    // operators in Scala are actually methods
    val basicMath = 1 + 2
    val anotherBasicMath = 1.+(2) //equivalent

    // anonymous classes
    val dinosaur = new Carnivore {
        override def eat(animal: Animal): Unit = println("I'm a dinosaur and I'm eating you, animal!")
    }
    /*
        What you tell the compiler:
        
        class Carnivore_Anonymous_135 extends Carnivore {
            override def eat(animal: Animal): Unit = println("I'm a dinosaur and I'm eating you, animal!")
        }
        val dinosaur = new Carnivore_Anonymous_135
    */

    // singleton object
    object MySingleton {
        val mySpecialValue = 672
        def mySpecialMethod(): Int = 673
        def apply(x: Int): Int = x + 1
    }
    
    MySingleton.mySpecialMethod()
    MySingleton.apply(45)
    MySingleton(45) // equivalent to MySingleton.apply(45)

    object Animal {
        // companions can access each other's private fields/methods
        // singleton Animal and instances of the Animal class are called companions
        val canLiveIndefinitely = false
    }

    val animalsCanLiveForever = Animal.canLiveIndefinitely // "static" fields/methods
    // println(animalsCanLiveForever)
    // println(aCroc.age)

    /*
       case classes = lightweight data structures with some boilerplate
       - sensible equals and hashcode
       - serialization
       - companion with apply      
       - pattern matching
    */
    case class Person(name: String, age: Int)
    // may be constucted without new
    val bob = Person("Bob", 43) // Person.apply("Bob", 43)
    println(bob.name)

    // exceptions
    try {
        // code that might throw
        val x: String = null
        x.length
    } catch { // in Java: catch (NullPointerException e) {...}
        case e: Exception => "some faulty error message"
    } finally {
        // code that will get executed NO MATTER WHAT
        println("some logs")
    }

    // generics
    abstract class MyOwnList[T] {
        def head: T
        def tail: MyOwnList[T]
    }

    // using a generic with a concrete type
    val aList: List[Int] = List(1, 2, 3)
    val first = aList.head // int
    val rest = aList.tail
    val aStringList = List("hello", "Scala")
    val firstString = aStringList.head // string

    // point #1: in Scala we usually operate with IMMUTABLE values/objects
    // Any modification to an object must return ANOTHER object
    /*
        Benefits:
        1) works miracles in multithreaded/distributed envs
        2) helps making sense of the code ("reasoning about")
    */
    val reverseList = aList.reverse // returns a new list

    // point #2: Scala is closest to the OO ideal





    

}
