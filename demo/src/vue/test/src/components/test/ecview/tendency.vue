<template>
    <div class="line1">
        <div id="line1" class="" style="width: 90%;height:450px;"></div>
    </div>
</template>

<script>
import echarts from 'echarts/lib/echarts'
// 引入柱状图
import 'echarts/lib/chart/bar'
import 'echarts/lib/chart/line'
import 'echarts/lib/component/title'
import 'echarts/lib/component/legend'
import 'echarts/lib/component/toolbox'
import 'echarts/lib/component/markPoint'
import 'echarts/lib/component/tooltip'
export default {
  mounted () {
    this.myChart = echarts.init(document.getElementById('line1'))
    this.initData()
  },
  props: ['sevenDate', 'sevenDay'],
  methods: {
    initData () {
      const colors = ['#5793f3', '#675bba', '#d14a61']
      const option = {
        color: colors,
        title: {
          text: 'Echarts构建的图',
          subtext: '',
          top: '6px'
        },
        tooltip: {
          trigger: 'axis'
        },
        legend: {
          data: ['新注册用户', '新增订单', '新增水果']
        },
        toolbox: {
          show: true,
          feature: {
            dataZoom: {
              yAxisIndex: 'none'
            },
            dataView: {
              readOnly: true,
              lang: ['数据视图', '关闭'],
              optionToContent: function (opt) {
                let axisData = opt.xAxis[0].data // 坐标数据
                let series = opt.series // 折线图数据
                let tdHeads = '<td  style="padding: 0 10px">时间</td>' // 表头
                let tdBodys = '' // 数据
                series.forEach(function (item) {
                  // 组装表头
                  tdHeads += `<td style="padding: 0 10px">${item.name}</td>`
                })
                let table = `<table border="1" style="margin-left:20px;border-collapse:collapse;font-size:14px;text-align:center"><tbody><tr>${tdHeads} </tr>`
                for (let i = 0, l = axisData.length; i < l; i++) {
                  for (let j = 0; j < series.length; j++) {
                    // 组装表数据
                    tdBodys += `<td>${series[j].data[i]}</td>`
                  }
                  table += `<tr><td style="padding: 0 10px">${axisData[i]}</td>${tdBodys}</tr>`
                  tdBodys = ''
                }
                table += '</tbody></table>'
                return table
              }
            },
            magicType: { type: ['line', 'bar', 'stack', 'tiled'] },
            restore: {}
          }
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: this.sevenDay
        },
        yAxis: [
          {
            type: 'value',
            name: '用户',
            min: 0,
            max: 30,
            position: 'left',
            axisLine: {
              lineStyle: {
                color: '#999'
              }
            },
            axisLabel: {
              formatter: '{value}'
            }
          },
          {
            type: 'value',
            name: '订单',
            min: 0,
            max: 30,
            position: 'right',
            axisLine: {
              lineStyle: {
                color: '#999'
              }
            },
            axisLabel: {
              formatter: '{value}'
            }
          }
        ],
        series: [
          {
            name: '新注册用户',
            type: 'line',
            data: [1, 5, 3, 4, 5, 6, 7],
            yAxisIndex: 1,
            markPoint: {
              data: [
                { type: 'max', name: '最大值' },
                { type: 'min', name: '最小值' }
              ]
            }
          },
          {
            name: '新增订单',
            type: 'line',
            data: [8, 5, 10, 11, 12, 13, 14],
            yAxisIndex: 1,
            markPoint: {
              data: [
                { type: 'max', name: '最大值' },
                { type: 'min', name: '最小值' }
              ]
            }
          },
          {
            name: '新增水果',
            type: 'line',
            data: [15, 5, 17, 18, 19, 20, 21],
            yAxisIndex: 1,
            markPoint: {
              data: [
                { type: 'max', name: '最大值' },
                { type: 'min', name: '最小值' }
              ]
            }
          }
        ]
      }
      this.myChart.setOption(option)

      window.onresize = this.myChart.resize
    }
  },
  watch: {
    sevenDate: function () {
      this.initData()
    },
    sevenDay: function () {
      this.initData()
    }
  }
}
</script>

<style lang="less">
@import "../../style/mixin";
.line1 {
    display: flex;
    justify-content: center;
}
</style>
