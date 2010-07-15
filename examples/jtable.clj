(ns jtable-example
  (:import (javax.swing JFrame JTable JScrollPane JPanel))
  (:import (java.awt Dimension)))

(def columns ["Book" "Author"])

(def data [["On Lisp" "Paul Graham"]
           ["Practical Common Lisp" "Peter Seibel"]
           ["Programming Clojure" "Stuart Holloway"]])

(defn default-editable-table
  []
  (let [ frame (JFrame. "Default table demo") panel (JPanel.) scroll-pane (JScrollPane. (JTable. (to-array-2d data)  (into-array columns)))]
    (doto frame
      (.add scroll-pane)
      (.pack)
      (.setVisible true))))
