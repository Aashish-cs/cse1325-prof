P02 Extreme Bonus AI Engine
===========================

This baseline is ONLY needed for students attempting the Extreme Bonus portion of this assignment!

Eliza is a VERY simple "AI Engine" from 1966 that attempts to mimic a psychologist by responding to your statements with (mostly) questions intending to elicit more insightful discussion. 

To interact with Eliza, the only class you'll need to instance is ``Eliza`` itself, in the Eliza.java file in the eliza subdirectory. After duplicating your code from the bonus directory, simply copy the ENTIRE eliza subdirectory to your extreme_bonus directory (that is, as cse1325/P02/extreme_bonus/eliza) and modify your own AI.java file (in cse1325/P02/extreme_bonus) to ``import eliza.Eliza``, instance the ``Eliza`` class, and then in method ``query`` pass the query to ``eliza.processInput(query)`` and return its response.

