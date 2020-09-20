  
import React from 'react';
import { mount, configure} from 'enzyme';
import { MemoryRouter } from 'react-router';
import NavigationBarWorkerPage from '../Layout/NavigationBarWorkerPage';
import App from '../../App'
import Adapter from 'enzyme-adapter-react-16';
import ShallowRenderer from 'react-test-renderer/shallow';
import {cleanup} from '@testing-library/react';

afterEach(cleanup);
configure({ adapter: new Adapter() });

test('valid path for worker page', () => {
    const wrapper = mount(
      <MemoryRouter initialEntries={[ '/worker/login' ]}>
        <App/>
      </MemoryRouter>
    );
    expect(wrapper.find(<NavigationBarWorkerPage/>)).toHaveLength(0);
  });

it("Worker nav bar is rendered correctly", () =>{
  const renderer = new ShallowRenderer();
  renderer.render(<NavigationBarWorkerPage/>);
  const result = renderer.getRenderOutput();
  console.log(result);
  expect(result.type).toBe('div');
  expect(result.props.children).toBe('ul');
});