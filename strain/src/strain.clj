(ns strain)

(defn retain [pred coll]
  (for [x coll :when (pred x)] x))

(defn discard [pred coll]
  (for [x coll :when ((complement pred) x)] x))


