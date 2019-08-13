(ns strain)

(defn retain [pred coll]
  (for [x coll :when (pred x)] x))

(defn discard [pred coll] (retain (complement pred) coll))



