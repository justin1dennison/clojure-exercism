(ns beer-song
  (:require [clojure.string :as string]))


(defn verse-data [n]
  (case n
    0 ["No more bottles", "no more bottles", "Go to the store and buy some more", "99 bottles"]
    1 ["1 bottle", "1 bottle", "Take it down and pass it around", "no more bottles"]
    2 ["2 bottles" "2 bottles", "Take one down and pass it around", "1 bottle"] 
    [(str n " bottles")
     (str n " bottles")
     "Take one down and pass it around"
     (str (dec n) " bottles")]))

(def verse-template
  (str "%s of beer on the wall, %s of beer.\n"
       "%s, %s of beer on the wall.\n"))

(defn verse
  "Returns the nth verse of the song."
  [num]
  (let [[a b c d] (verse-data num)]
    (format verse-template a b c d)))


(defn sing
  "Given a start and an optional end, returns all verses in this interval. If
  end is not given, the whole song from start is sung."
  ([start]  (sing start 0))
  ([start end] (->>
                (range start (dec end) -1)
                (map verse)
                (string/join "\n"))))
