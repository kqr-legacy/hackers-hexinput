# TODO

Trying to get some sense of where I am and where I need to be going. This will
probably need a lot of refinement...


## What the fuck is this table?

The first column is "version.section.number". The section is either B for Basic, which
is a fundamental requirement of the app, or T for Tentative, which is a requirement
that's not explored yet and may very well be a bad idea.


## Requirements

|   #   | Status | Description |
|------:|:------:|:------------|
| 0.B.01  | X | The keys MUST be pointy-topped hexagons |
| 0.B.02  | | The keys MUST be laid out in a hexagonal grid |
| 0.B.03  | | Each key MUST be associated with a primary symbol |
| 0.B.04  | | Each Key MUST be associated with alternate symbols
| 0.B.04  | | The "start press" event for a key MUST be triggered when a "touch down" event intersects the key
| 0.B.05  | | The "start press" event for a key MUST be triggered when a "touch move" event intersects the key
| 0.B.06  | | The "tap" event for a key MUST be triggered when a "touch up" event intersecting the key occuring within "longpress" time after a "start press" event for the same key
| 0.B.07  | | The "hold" event for a key MUST be triggered when "longpress" time has passed since "start press" and no "slide" or "tap" has happened since
| 0.B.08  | | The "slide" event for a key MUST be triggered when the touch move event intersects a different key
| 0.B.09  | | The "slide" event for a key MUST NOT be triggered when the user slides from the key to space not occupied by another key
| 0.B.10 | | The "tap" event must produce the primary symbol for the key (0.B.03)
| 0.B.11 | | The "hold" event must open a make the neighbouring keys produce the alternate symbols for the key


* T if a certain combination is swiped, temporarily change the layout to allow continuing swipe?