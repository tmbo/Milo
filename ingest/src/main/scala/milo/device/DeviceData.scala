package milo.device

trait DeviceData{
  def time: Long
  def seq: Int
  def measurements: Seq[Measurement]
}