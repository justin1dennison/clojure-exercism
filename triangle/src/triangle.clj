(ns triangle
  (:require [clojure.math.combinatorics :as c]))

(defn type [a b c]
  (let [sides (list a b c)
        [x y z] (sort sides)]
    (if (and (< z (+ x y)) (every? #(> % 0) sides))
      (cond
        (= a b c) :equilateral
        (some (partial apply =) (c/combinations sides 2)) :isosceles
        :else :scalene)
      :illogical)))
