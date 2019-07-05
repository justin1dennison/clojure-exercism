(ns phone-number)

(defn strip [coll chars]
  (apply str (remove #((set chars) %) coll)))

(defn number [num-string]
  (let [stripped (strip num-string "- ( ) .")]
    (cond
      (= (count stripped) 11)
      (if (= (first stripped) \1)
        (subs stripped 1)
        "0000000000")
      (< (count stripped) 10) 
        "0000000000"
      :else stripped)))

(defn area-code [num-string]
  (subs (number num-string) 0 3))

(defn pretty-print [num-string]
  (let [n (number num-string)]
    (str
     "("
     (area-code num-string)
     ") "
     (subs n 3 6)
     "-"
     (subs n 6))))
