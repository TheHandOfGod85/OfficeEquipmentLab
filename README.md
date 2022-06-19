# OfficeEquipmentLab

<h2>Description</h2>
A lab where I refactor a project for improvement and add extra features.

<h2>Skills learnt</h2>

<ul>
<li>Reinforce the HTTLAP problem solving process.</li>
<li>Understand the uses of inheritance in problem solving.</li>
<li>Work with inheritance and connected concepts in Java.</li>
<li>Understand and use of the concept of Pattern Design (Observer Design here).</li>  
</ul>


<h2>Languages and Utilities Used</h2>

- <b>Java</b> 
- <b>Eclipse</b>

<h2>Environments Used </h2>

- <b>Windows 10</b> (21H2)

<h2>Specification part ONE</h2>
Model a network of typical office equipment (a printer, a photocopier, a scanner, a coffee
machine and a vending machine) along with a simple monitoring/management tool which
will be able to notify users of the status (online, offline or in error state) of each connected
piece of equipment. All machines have unique alphanumeric codes and can process jobs
(only one at a time, no tracking of when jobs were entered into the system is needed at this
time). A job will have a code (alphanumeric and unique), an owner (the person who ordered
it) and a description (e.g., “Print document xyz.” or “Make a large latte macchiato.”). The job
and machine codes always start with three letters that describe the type of the job/machine,
followed by a combination of three digits. The letters at the start of the job code are:
<ul>
  <li>PRT print job / printer</li>
  <li>SCN scan job / scanner</li>
  <li>CPY copy job / copier</li>
  <li>CFE make coffee job / coffee machine</li>
  <li>VND dispense food from vending machine job / vending machine</li>
</ul>
<h2>Specification part TWO</h2>
Every piece of office equipment:
<ul>
  <li>Registers a listener. The machine receives an object representing the listener and
stores it internally (assigns it to a field declared for this purpose).</li>
  <li>Notifies the listener. Whenever the machine goes online, offline or enters an error
state, it prompts the internal listener to show its full description including the new
status.</li>
</ul>
The manager is the only machine that can act as a listener. Once it receives a notification
from a machine in the system, it displays the full description of that machine.
Registering and notifying listeners are not specific to office equipment only (the air
conditioning unit - modelled in a separate hierarchy - implements those two operations as
well). Similarly, the manager is not the only one that can show the status of a machine:
other managers, produced by other organisations, should be usable in the system. Other
monitoring systems exist that are able to perform that task. You are not asked to model air
conditioning units or other monitoring systems, but, the fact that they exist and may be
added to your model by someone else at a later point should give you an indication of
where to put methods registerListener(), notifyListener() and showStatus().

<!--
 ```diff
- text in red
+ text in green
! text in orange
# text in gray
@@ text in purple (and bold)@@
```
--!>
