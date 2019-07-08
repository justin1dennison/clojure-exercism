(ns reverse-string)

(defn reverse-string [s]
  (loop [string s results []]
    (if (zero? (count string))
      (clojure.string/join "" results)
      (recur 
        (subs string 1) 
        (cons (subs string 0 1) results)))))

