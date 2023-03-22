package com.rockthejvm.problems

object Justifier extends App {

    def justify(text: String, width: Int): Unit = {
        def justifyRec(words: List[String], current_word: String, current_len: Int, current_line: List[String], lines: List[List[String]]): List[List[String]] = {
            // println(current_len)
            if (words.isEmpty && current_word.length + current_len + 1 <= width) 
                lines :+ (current_line :+ current_word)
            else if (words.isEmpty) 
                lines :+ (current_line) :+ (List(current_word))
            else if (current_word.length + current_len + 1 <= width) 
                justifyRec(words.tail, words.head, current_word.length + current_len + 1, current_line :+ current_word, lines)
            else 
                justifyRec(words.tail, words.head, current_word.length, List(current_word), lines :+ (current_line))
        }

        val words = text.split(' ').toList
        val result = justifyRec(words.tail, words.head, 0, List(), List())

        def space_creator(n: Int): String = " " * n
        def boolToInt(b: Boolean): Int = {
            b match {
                case true => 0
                case false => 1
            }
        }
        
        def extend(line: (List[String], Int)): String = {
            val all_word_count = line._1.length
            val space_count = ((width - line._2) / (all_word_count - 1))
            val rest_count = ((width - line._2) % (all_word_count - 1))
            def joiner(line: List[String], word: String, word_count: Int, result: String): String = {
                if (result.isEmpty && line.isEmpty) word
                else if (result.isEmpty) joiner(line.tail, line.head, word_count + 1, word)
                else if (line.isEmpty) result + space_creator(space_count + boolToInt(word_count <= rest_count)) + word
                else joiner(line.tail, line.head, word_count + 1, result + space_creator(space_count + boolToInt(word_count <= rest_count)) + word)
            }
            joiner(line._1.tail, line._1.head, 1, "")
        }

        def pack(line: List[String]): String = {
            val wordCount = line.length
            val letterCount = line.map(x => x.length).sum
            val spaceCount = width - letterCount
            val spaceFixedNum = spaceCount / (wordCount-1)
            val spaceRestNum = spaceCount % (wordCount-1)
            // print(spaceFixedNum, spaceRestNum)

            def spaceCreator(wordNum: Int): String = {
                val rest = boolToInt(wordNum - 2 >= spaceRestNum)
                // print(wordNum, spaceRestNum, rest)
                space_creator(spaceFixedNum + rest)
            }

            def packTailRec(line: List[String], currentWord: String, currentWordNum: Int, result: String): String = {
                if (result == "")
                    packTailRec(line.tail, line.head, currentWordNum + 1, currentWord)
                else if (line.isEmpty) 
                    result + spaceCreator(currentWordNum) + currentWord
                else 
                    packTailRec(line.tail, line.head, currentWordNum + 1, result + spaceCreator(currentWordNum) + currentWord)    
            }
            packTailRec(line.tail, line.head, 1, "")
        }

        val finalresult = result.dropRight(1).map(pack) :+ result.last.mkString(" ")
        finalresult.foreach(println)
        // for {
        //     line <- result
        // } yield println("$" + pack(line) + "$")

    }

    print(justify("Scala is the most amazing language you will ever write any code in.", 15))
    println()
    print(justify("Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint obcaecat cupiditat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 80))
  
    
}
